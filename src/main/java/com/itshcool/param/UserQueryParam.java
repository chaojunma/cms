package com.itshcool.param;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserQueryParam extends PageParam{

	// 关键字
	private String key;
	
	// 创建时间
	private String createTime;
	
	// 是否锁定
	private Integer isLock;
}
