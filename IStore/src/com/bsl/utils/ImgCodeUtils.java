package com.bsl.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//作为验证码工具类，暂时未实现
public class ImgCodeUtils {
	
	//获取验证码的请求处理
		public String getImgCode(HttpServletRequest request,
				HttpServletResponse response,HttpSession session) throws IOException{
			//设置验证码的规格
			int width = 120;
			int height = 30;
			//步骤一：绘制一张内存中的图片
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			//步骤二：图片绘制背景颜色----使用绘图对象
			Graphics graphics = bufferedImage.getGraphics();	//得到画图对象---画笔
			//指定颜色
			graphics.setColor(getRandColor(200, 180));
			graphics.fillRect(0, 0, width, height);
			//步骤三：绘制边框
			graphics.setColor(Color.WHITE);
			graphics.drawRect(0, 0, width-1, height-1);
			//步骤四：4个随机数字
			Graphics2D graphics2d = (Graphics2D) graphics;
			graphics2d.setFont(new Font("宋体", Font.BOLD, 16));//设置字体大小及格式
				//随机生成字母或数字来使用
			String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
			Random random = new Random();
			StringBuffer sb = new StringBuffer();
			int x = 10;				//定义x坐标
			for (int i = 0; i < 4; i++) {
				//随机颜色
				graphics2d.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
				//旋转-30到30度
				int jiaodu = random.nextInt(60)-30;
				//换算成弧度
				double theta = jiaodu * Math.PI / 180;
				//生成一个随机数字是字母数字的长度
				int index = random.nextInt(words.length());
				char c = words.charAt(index);
				sb.append(c);
				//将c输出到图片中
				graphics2d.rotate(theta, x, 20);
				graphics2d.drawString(String.valueOf(c), x, 20);
				graphics2d.rotate(-theta, x, 20);
				x+=30;
			}
			
			//将生成的字母存入session中
			session.setAttribute("checkcode", sb.toString());
			//步骤五：绘制干扰线
			graphics.setColor(getRandColor(160,200));
			int x1;
			int x2;
			int y1;
			int y2;
			for (int i = 0; i < 30; i++) {
				x1 = random.nextInt(width);
				x2 = random.nextInt(20);
				y1 = random.nextInt(height);
				y2 = random.nextInt(20);
				graphics.drawLine(x1, y1, x1+x2, x2+y2);
			}
			//将上面的图片输出到浏览器
			graphics.dispose();
			ImageIO.write(bufferedImage, "jsp", response.getOutputStream());
			return "";
		}
		
		
	//随机获取颜色
	private Color getRandColor(int fc,int bc){
		Random random = new Random();
		if (fc>255) {
			fc=255;
		}
		if (bc>255) {
			bc=255;
		}
		int r = fc + random.nextInt(fc-bc);
		int g = fc + random.nextInt(fc-bc);
		int b = fc + random.nextInt(fc-bc);
		return new Color(r, g, b);
	}
}
