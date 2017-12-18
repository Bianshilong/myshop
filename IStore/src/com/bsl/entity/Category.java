package com.bsl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="category")
@Getter@Setter
public class Category {
	
	@Id@Column(name="c_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String name;
}
