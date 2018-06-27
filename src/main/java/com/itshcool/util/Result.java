package com.itshcool.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 返回结果封装类
 * @author maming
 * @date 2018年6月27日
 */
@Setter
@Getter
@AllArgsConstructor
public class Result {

	private Integer code; //状态码
	
	private String message; //描述
	
	private Object data; //返回数据
	
	public Result() {
		code = 200;
		message = "success";
	}
	
	public Result(ResultCode resultCode) {
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
	}
	
	public Result(ResultCode resultCode, Object data) {
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
		this.data = data;
	}
	
}
