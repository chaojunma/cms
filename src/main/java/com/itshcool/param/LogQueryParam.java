package com.itshcool.param;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogQueryParam extends PageParam {

	// 关键字
	private String key;
	// 创建时间
	private String createTime;
	// 日志级别
	private String level;
}
