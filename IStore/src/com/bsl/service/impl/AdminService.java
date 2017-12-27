package com.bsl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsl.dao.IAdminDao;
import com.bsl.entity.Admin;
import com.bsl.entity.User;
import com.bsl.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private IAdminDao dao;

	@Override
	public void add(Admin admin) {
		dao.save(admin);

	}

	@Override
	public List<Admin> findByNameAndPass(Admin admin) {
		List<Admin> list = dao.findByNameAndPass(admin);
		return list;
	}

	@Override
	public boolean checklogin(Admin admin) {
		List<Admin> list = dao.findByNameAndPass(admin);
		boolean flag =false;
		if (list.size()>0) {
			flag=true;
		}
		return flag;
	}
}
