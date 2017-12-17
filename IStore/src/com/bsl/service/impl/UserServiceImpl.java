package com.bsl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsl.dao.IUserDao;
import com.bsl.entity.User;
import com.bsl.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	

	@Autowired
	private IUserDao dao;
	
	@Override
	public void add(User user) {
		dao.save(user);
	}
	
	@Override
	public boolean checklogin(User user) {
		List<User> list = dao.findByNameAndPass(user);
		boolean flag =false;
		if (list.size()>0) {
			flag=true;
		}
		return flag;
	}
}
