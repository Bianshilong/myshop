package com.bsl.service;

import java.util.List;

import com.bsl.entity.Admin;

public interface IAdminService {
	
	//新增管理员
	void add(Admin admin);
	
	//查询管理员
	List<Admin> findByNameAndPass(Admin admin);
	
	boolean checklogin(Admin admin);
}
