package com.itshcool.controller;

import com.itshcool.annotation.JAction;
import com.itshcool.model.ClassInfo;
import com.itshcool.param.PageParam;
import com.itshcool.service.ClassService;
import com.itshcool.util.PageResult;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;


/**
 * 课程控制器
 * @author chaojunma
 *	@date 2018年7月9日
 */
@JAction("/class")
public class ClassController extends Controller{
	
	
	private static final ClassService classService = new ClassService();
	
	
	/**
	 * 分页查询
	 */
	public void list(){
		PageParam param = getBean(PageParam.class, "");
		Page<ClassInfo> data = classService.list(param);
		PageResult<ClassInfo> result = new PageResult<>(data);
		renderJson(result);
	}

}
