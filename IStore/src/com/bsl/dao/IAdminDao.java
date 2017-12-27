package com.bsl.dao;

import java.util.List;

import com.bsl.entity.Admin;

public interface IAdminDao extends IBaseDao<Admin>{

	//根据用户名和密码查询
	List<Admin> findByNameAndPass(Admin admin);
}
