package com.bsl.dao;

import java.util.List;

import com.bsl.entity.Product;

public interface IProduct extends IBaseDao<Product> {
	
	//通过是否热门搜索商品
	List<Product> findByHot();
	
	//通过是否下架搜索商品
	List<Product> findByFlag();
	
	//根据Id来搜索商品
	List<Product> findById();
}
