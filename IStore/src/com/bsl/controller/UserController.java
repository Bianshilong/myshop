package com.bsl.controller;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bsl.constant.IConstant;
import com.bsl.entity.User;
import com.bsl.service.IUserService;
import com.bsl.utils.CaptchaUtil;
import com.bsl.utils.ImgCodeUtils;
import com.bsl.utils.UUCodeUtils;
import com.bsl.vo.Vo_user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Controller
@RequestMapping(value="/user")
public class UserController {

	 @Autowired
	private IUserService userService;
	// 验证用户登录的方法
	@RequestMapping(value = "/login")
	public String login(Vo_user vr) {
		User user = new User(vr.getUsername(),vr.getPassword());
		String str=null;
		if (userService.checklogin(user)) {
			str="success";
		}
		return str;
	}
	
	//跳转至注册页面
	@RequestMapping(value="/registUI")
	public String registUI(){
		return "register";
	}
	//跳转至注册页面
	@RequestMapping(value="/loginUI")
	public String loginUI(){
		return "login";
	}
	
	//用户注册页面，注册成功后，显示信息,邮箱激活的功能暂未实现
	@RequestMapping(value="/regist")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Vo_user vr) {
		ModelAndView mv = new ModelAndView();
		String imgcode = (String) session.getAttribute("randomString");
		if ("" == vr.getUsername().trim() || "" == vr.getRepassword()
				|| "" == vr.getEmail().trim() || "" ==vr.getCheckcode().trim() || !(imgcode.equals(vr.getCheckcode()))) {
			mv.addObject("usermsg", "很抱歉，您输入的信息不完整，无法注册成功，请重新输入");
			mv.setViewName("usermsg");
		}else{
			User user = pushUser(vr);
			userService.add(user);
			mv.addObject("usermsg", "恭喜您注册成功！");
			mv.setViewName("usermsg");
		}
		
		return mv;
	}
	
	//获取验证码
		@RequestMapping(value="/checkImg")
		@ResponseBody
	    public void getAuthCode(HttpServletRequest request, HttpServletResponse response,HttpSession session)
	            throws IOException, ServletException {
			CaptchaUtil.outputCaptcha(request, response);
			
		}

	//将前端页面传递的信息封装至user实例中
	private User pushUser(Vo_user vr) {
		User user = new User();
		
		user.setUsername(vr.getUsername());
		user.setPassword(vr.getPassword());
		user.setName(vr.getName());
		
		user.setSex(vr.getSex());
		user.setBirth(vr.getBirth());
		user.setTelephone(vr.getTelephone());
		
		user.setEmail(vr.getEmail());
		user.setState(IConstant.USER_IS_NOT_ACTIVE);
		user.setCode(UUCodeUtils.getCode());
		return user;
	}
}
