package com.bsl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsl.entity.Admin;
import com.bsl.service.IAdminService;
import com.bsl.vo.Vo_admin;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService service;
	
	@RequestMapping(value="/loginUI")
	public String getLogin() {
		return "admin/login";
	}
	
	@RequestMapping(value="login")
	@ResponseBody
	public String login(HttpServletRequest request,HttpSession session,Vo_admin vo_admin) {
		String str = "";
		Admin admin = new Admin();
		admin.setName(vo_admin.getName());
		admin.setPassword(vo_admin.getPassword());
		if (service.checklogin(admin)) {
			session.setAttribute("admin", vo_admin.getName());
			str="admin/manage";
		}else {
			request.setAttribute("error_msg", "您输入的用户名或密码错误！");
			str = "admin/login";
		}
		return str;
	}
}
