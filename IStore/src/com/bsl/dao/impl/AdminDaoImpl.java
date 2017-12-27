package com.bsl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bsl.dao.IAdminDao;
import com.bsl.entity.Admin;

@Repository
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements IAdminDao{

	@Override
	public List<Admin> findByNameAndPass(Admin admin) {
		List<Admin> list = find("select a from Admin a where a.name=?1 and a.password=?1"
								,admin.getName(),admin.getPassword());
		return list;
	}

}
