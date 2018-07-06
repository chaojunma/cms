package com.itshcool.controller;

import com.itshcool.annotation.JAction;
import com.itshcool.interceptor.LogInterceptor;
import com.itshcool.model.Classify;
import com.itshcool.param.ClassifyQueryParam;
import com.itshcool.service.ClassifyService;
import com.itshcool.util.PageResult;
import com.itshcool.util.Result;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * 课程分类控制器
 * @author chaojunma
 * @date 2018年7月6日
 */
@JAction("classify")
public class ClassifyController extends Controller{
	
	private static final ClassifyService classifyService = new ClassifyService();
	
	/**
	 * 课程分类分页查询
	 */
	public void list(){
		ClassifyQueryParam param = getBean(ClassifyQueryParam.class, "");
		Page<Classify> data = classifyService.list(param);
		PageResult<Classify> result = new PageResult<>(data);
		renderJson(result);
	}
	
	
	/**
	 * 删除
	 */
	@Before(LogInterceptor.class)
	public void delete(){
		classifyService.deleteById(getParaToInt("id"));
		renderJson(new Result());
	}
	
	
	/**
	 * 保存或更新
	 */
	@Before(LogInterceptor.class)
	public void saveOrUpdate(){
		Classify classify = getModel(Classify.class, "");
		if(classify.get("id") != null) {
			classify.update();
		} else {
			classify.save();
		}
		renderJson(new Result());
	}

}
