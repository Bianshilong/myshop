package com.bsl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter@Setter
public class Product {
	/**
	 * product
	 * pId   			商品ID			Long
	 * pName 	    	商品名称			String
	 * pPrice			商城价			Double
	 * 
	 * pMarketPrice		市场价			Double
	 * pImg				商品图片			String
	 * pDesc			商品描述			String
	 * 
	 * pTime			上架时间			String
	 * pHot				是否热门			Boolean
	 * pFlag			是否下架			Boolean
	 *c_id				分类id			Category
	 */
	@Id@Column(name="p_name")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	
	private Double marketPrice;
	private String img;
	private String description;
	
	private String time;
	private Boolean hot;
	private Boolean flag;
	
	@ManyToOne(targetEntity=Category.class)
	@JoinColumn(name="c_id",referencedColumnName="c_id",nullable=false)
	private Category category;
	
	//无参的构造方法
	public Product() {
	}
	
	
}
