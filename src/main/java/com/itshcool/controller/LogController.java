package com.itshcool.controller;

import com.itshcool.annotation.JAction;
import com.itshcool.model.SysLog;
import com.itshcool.param.LogQueryParam;
import com.itshcool.service.LogService;
import com.itshcool.util.PageResult;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * 日志控制器
 * @author chaojunma
 * @date 2018年7月3日
 */
@JAction("/log")
public class LogController extends Controller{
	
	private static final LogService logService = new LogService();

	/**
	 * 日志列表
	 */
	public void list(){
		LogQueryParam param = getBean(LogQueryParam.class, "");
		Page<SysLog> data = logService.list(param);
		PageResult<SysLog> result = new PageResult<>(data);
		renderJson(result);
	}
}
