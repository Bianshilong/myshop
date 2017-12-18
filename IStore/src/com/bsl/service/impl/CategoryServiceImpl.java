package com.bsl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsl.dao.ICategoryDao;
import com.bsl.entity.Category;
import com.bsl.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao; 
	
	@Override
	public List<Category> findAll(Class<Category> category) {
		List<Category> list = categoryDao.findAll(category);
		return list;
	}

}
