package com.liujiadong.cms.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
	
	private static String salt="ljd";
	
	public static String encode(String password){
		return DigestUtils.md5Hex(password+salt);
	}
}
