package com.bsl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsl.dao.IProductDao;
import com.bsl.entity.Product;
import com.bsl.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductDao dao;
 
	@Override
	public void add(Product product) {
		dao.save(product);
		
	}

	@Override
	public void deleteById(Product product, Long id) {
		dao.delete(Product.class,id);
	}

	@Override
	public void update(Product product) {
		dao.update(product);
		
	}

	@Override
	public List<Product> getAll(Product product) {
		List<Product> list = dao.findAll(Product.class);
		return list;
	}

	@Override
	public List<Product> getByHot(Byte hot) {
		List<Product> list = dao.findByHot(hot);
		return list;
	}

	@Override
	public List<Product> getByFlag(Byte flag) {
		List<Product> list = dao.findByFlag(flag);
		return list;
	}

	@Override
	public Product getById(Long id) {
		Product product = dao.findById(id).get(0);
		return product;
	}

	@Override
	public List<Product> getByIds(String ids) {
		List<Product> list = dao.getByIds(ids);
		return list;
	}

}
