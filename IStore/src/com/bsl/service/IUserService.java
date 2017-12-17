package com.bsl.service;

import com.bsl.entity.User;

public interface IUserService {
	
	void add(User user);

	boolean checklogin(User user);
}
