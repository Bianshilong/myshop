package com.bsl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bsl.dao.IProductDao;
import com.bsl.entity.Product;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements IProductDao {

	@Override		//根据是否是热门商品来查询商品列表
	public List<Product> findByHot(Byte hot) {
		List<Product> list = find("select p from Product p where p.hot = ?0",hot);
		return list;
	}

	@Override		//根据商品是否下架来查询商品，返回列表
	public List<Product> findByFlag(Byte flag) {
		List<Product> list = find("select p from Product p where p.flag = ?0",flag);
		return list;
	}

	@Override		//根据商品的id来查询商品，返回商品列表
	public List<Product> findById(Long id) {
		List<Product> list = find("select p from Product p where p.id = ?0",id);
		return list;
	}

	@Override		//根据商品的id来查询商品，返回单个商品
	public List<Product> getByIds(String ids) {
		List<Product> list = find("select p from Product p where p.id in( ?0 )",ids);
		return list;
	}

}
