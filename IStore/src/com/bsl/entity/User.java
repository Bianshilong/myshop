package com.bsl.entity;

//import javax.persistence.*;			//可以用*代表导入所有的该类型包

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="user_info")
@Getter@Setter
public class User {
	
	/**
	 * id  Long
	 * username  String
	 * password  String
	 * 
	 * name		String
	 * email	String
	 * tell		String
	 * 
	 * birth	String
	 * sex		String
	 * state	Integer
	 * 
	 * code		String
	 */
	
	@Id@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String email;
	
	private String name;
	private String sex;
	private String birth;
	
	private String telephone;
	private Integer state;
	private String code;
	
	//提供无参的构造函数
	public User() {
	}
	
	//通过用户名和密码构造User实例
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
}
