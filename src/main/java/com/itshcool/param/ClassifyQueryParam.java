package com.itshcool.param;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClassifyQueryParam extends PageParam{
	
	// 分类名称
	private String name;
	
	// 创业实践
	private String createTime;
	
}
