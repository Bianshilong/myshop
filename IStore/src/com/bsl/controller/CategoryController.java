package com.bsl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsl.entity.Category;
import com.bsl.service.ICategoryService;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = "/findall")
	@ResponseBody
	public List<Category> findAll(HttpServletRequest request, HttpServletResponse response) {
		List<Category> list = categoryService.findAll(Category.class);
		
		for (Category category : list) {
			System.out.println(category.getId()+category.getName());
		}
		System.out.println("------");
		return list;
	}
}
