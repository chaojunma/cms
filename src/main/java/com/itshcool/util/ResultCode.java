package com.itshcool.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 返回状态码
 * @author maming
 * @date 2018年6月27日
 */
@Setter
@Getter
@AllArgsConstructor
public class ResultCode {

	public static final ResultCode SUCCESS = new ResultCode(200, "成功");
	public static final ResultCode PARAMETER_ERROR = new ResultCode(400, "请求数据非法");
	public static final ResultCode AUTHORIZE_FAIL_ERROR = new ResultCode(401, "用户未授权");
	public static final ResultCode FORBID_REQUEST_ERROR = new ResultCode(403, "访问被禁止");
	public static final ResultCode NOT_EXIST_ERROR = new ResultCode(404, "资源不存在");
	public static final ResultCode UNSUPPORTED_MEDIA_TYPE = new ResultCode(415, "错误的请求格式");
	public static final ResultCode METHOD_ERROR = new ResultCode(405, "请求方法错误");
	public static final ResultCode SERVER_ERROR = new ResultCode(500, "服务器错误");
	
	
	public static final ResultCode LOGIN_VALID_ERROR = new ResultCode(4001, "用户名或密码错误");
	
	// 状态码
	public Integer code;
	// 提示信息
	public String message;

}
