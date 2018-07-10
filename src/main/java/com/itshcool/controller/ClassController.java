package com.itshcool.controller;

import com.itshcool.annotation.JAction;
import com.itshcool.interceptor.LogInterceptor;
import com.itshcool.model.ClassInfo;
import com.itshcool.param.PageParam;
import com.itshcool.service.ClassService;
import com.itshcool.util.PageResult;
import com.itshcool.util.Result;
import com.jfinal.aop.Before;
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
	
	
	/**
	 * 保存或更新
	 */
	@Before(LogInterceptor.class)
	public void saveOrUpdate(){
		ClassInfo classInfo = getModel(ClassInfo.class, "");
		if(classInfo.get("id") != null){
			classInfo.update();
		} else {
			classInfo.save();
		}
		renderJson(new Result());
	}

}
