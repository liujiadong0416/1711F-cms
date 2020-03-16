package com.liujiadong.cms.utils;
/**
 * 
 * @ClassName: Result 
 * @Description: 杩斿洖缁熶竴鐨勭粨鏋滃��
 * @author: charles
 * @date: 2020骞�1鏈�11鏃� 涓嬪崍3:09:12 
 * @param <T>
 */
public class Result<T> {
   //杩斿洖缁撴灉鐨勭姸鎬�
	private Integer code;
	private String  msg;
	private T data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
