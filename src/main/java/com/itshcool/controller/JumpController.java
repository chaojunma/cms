package com.itshcool.controller;

import java.util.List;
import com.itshcool.annotation.JAction;
import com.itshcool.model.ClassSeries;
import com.itshcool.model.Classify;
import com.itshcool.service.ClassifyService;
import com.itshcool.service.SeriesService;
import com.jfinal.core.Controller;

/**
 * 页面跳转控制器
 * @author chaojunma
 * @date 2018年6月27日
 */
@JAction("/jump")
public class JumpController extends Controller{
	
	private static final ClassifyService classifyService = new ClassifyService();
	
	private static final SeriesService seriesService = new SeriesService();

	public void index() {
		String view = getPara(0) + ".html";
		switch (getPara(0)) {
		case "series_form":
			List<Classify> data	= classifyService.findAll();
			setAttr("data", data);
			break;
		case "class_list":
			List<ClassSeries> list = seriesService.findAll();
			setAttr("list", list);
			break;
		default:
			break;
		}
		render(view);
	}
	
}
