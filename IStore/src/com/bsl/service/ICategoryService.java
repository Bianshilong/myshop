package com.bsl.service;

import java.util.List;

import com.bsl.entity.Category;

public interface ICategoryService {
	
	List<Category> findAll(Class<Category> category);
}
