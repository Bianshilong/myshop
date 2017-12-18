package com.bsl.controller;

import java.io.IOException;

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
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Vo_user vr) {
		User user = new User(vr.getUsername(),vr.getPassword());
		ModelAndView mv = new ModelAndView();
		if (userService.checklogin(user)) {
			session.setAttribute("userexist", vr.getUsername());
			mv.addObject("userexist", vr.getUsername());
			mv.setViewName("index");
		}else {
			session.setAttribute("userexist", null);
			mv.addObject("userexist", null);
			mv.setViewName("login_error");
		}
		return mv;
	}
	
	//跳转至注册页面
	@RequestMapping(value="/registUI")
	public String registUI(){
		return "register";
	}
	//跳转至登录页面
	@RequestMapping(value="/loginUI")
	public String loginUI(){
		return "login";
	}
	//处理用户退出的请求页面
	@RequestMapping(value="/quit")
	public ModelAndView quit(HttpServletRequest request,HttpServletResponse response ,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.addObject("userexist", null);
		mv.setViewName("index");
		return mv;
	}
	
	//用户注册页面，注册成功后，显示信息,邮箱激活的功能暂未实现
	@RequestMapping(value="/regist") 
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Vo_user vr) {
		ModelAndView mv = new ModelAndView();
		String imgcode = (String) session.getAttribute("randomString");
		if ("" == vr.getUsername().trim() || "" == vr.getRepassword()
				|| "" == vr.getEmail().trim() || "" ==vr.getCheckcode().trim() || !(imgcode.equals(vr.getCheckcode()))) {
			mv.addObject("usermsg", "很抱歉，您输入的信息不完整，无法注册成功，<a href=\"<%=request.getContextPath() %>/user/registUI\">点此重新注册！</a>");
			mv.setViewName("usermsg");
		}else{
			User user = pushUser(vr);
			userService.add(user);
			mv.addObject("usermsg", "恭喜您注册成功！激活码为："+user.getCode());
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
