package com.bsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	//请求首页时，会自动查询数据库中所有的商品，再输出跳转至首页
	@RequestMapping(value="/index")
	public String getIndex(){
		
		return "index";
	}
}
