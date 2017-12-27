package com.bsl.service;

import java.util.List;

import com.bsl.entity.Product;

public interface IProductService {

	//添加商品
	void add(Product product);
	
	//删除商品,通过id来删除商品
	void deleteById(Product product, Long id);
	
	//更新商品
	void update(Product product);
	
	//查找所有商品
	List<Product> getAll(Product product);
	
	//根据热门查询商品
	List<Product> getByHot(Byte hot);
	
	//根据是否下架来查询商品
	List<Product> getByFlag(Byte flag);
	
	//根据id来获取单个实体
	Product getById(Long id);
	
	//根据id来获取list
	List<Product> getByIds(String ids);
}
