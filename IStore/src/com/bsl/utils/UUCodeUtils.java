package com.bsl.utils;

import java.util.UUID;

public class UUCodeUtils {
	
	/**
	 * 生成随机码
	 * @return
	 */
	public static String getCode(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
