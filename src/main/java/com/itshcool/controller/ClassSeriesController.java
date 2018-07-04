package com.itshcool.controller;

import com.itshcool.annotation.JAction;
import com.itshcool.model.ClassSeries;
import com.itshcool.param.SeriesQueryParam;
import com.itshcool.service.SeriesService;
import com.itshcool.util.PageResult;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * 课程系列控制器
 * @author chaojunma
 * @date 2018年7月4日
 */
@JAction("/series")
public class ClassSeriesController extends Controller{
	
	private static final SeriesService seriesService = new SeriesService();

	/**
	 * 课程系列分页查询
	 */
	public void list(){
		SeriesQueryParam param = getBean(SeriesQueryParam.class, "");
		Page<ClassSeries> data = seriesService.list(param);
		PageResult<ClassSeries> result = new PageResult<>(data.getTotalRow(), data.getList());
		renderJson(result);
	}
}
