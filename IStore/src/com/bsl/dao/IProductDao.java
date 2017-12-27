package com.bsl.dao;

import java.util.List;

import com.bsl.entity.Product;

public interface IProductDao extends IBaseDao<Product> {
	
	//通过是否热门搜索商品
	List<Product> findByHot(Byte hot);
	
	//通过是否下架搜索商品
	List<Product> findByFlag(Byte flag);
	
	//根据Id来搜索商品，返回商品列表
	List<Product> findById(Long id);
	
	//根据Id来获得商品，返回单个商品
	List<Product> getByIds(String ids);
}
