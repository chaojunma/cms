package com.itshcool.param;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageParam {

	// 页号
	private Integer page = 1;
	
	// 每页显示条数
	private Integer limit = 10;
	
	// 默认降序排序
	private String order = "desc";
	
	// 关键字
	private String key;
	
	// 创建时间
	private String createTime;
	
	// 日志等级
	private Integer level;
	
	// 用户是否锁定
	private Integer isLock;
}
