package com.bsl.vo;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Vo_user {
	
	/**
	 * 创建vo用来接收前端页面传递过来的参数
	 */
	private String username;
	private String password;
	private String repassword;
	
	private String name;
	private String sex;
	private String birth;
	
	private String telephone;
	private String email;
	private String checkcode;
	
}
