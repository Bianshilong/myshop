package com.bsl.dao;

import java.util.List;

import com.bsl.entity.User;

public interface IUserDao extends IBaseDao<User> {
	
		//根据用户名和密码查询
		List<User> findByNameAndPass(User user);
		
		//根据用户名查找
		User findByName(String name);
}
