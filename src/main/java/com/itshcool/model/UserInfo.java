package com.itshcool.model;

import com.itshcool.annotation.JTable;
import com.jfinal.plugin.activerecord.Model;


/**
 * 用户实体类
 * @author chaojunma
 * @date 2018年6月26日
 */

@JTable(tableName = "user_info", sqlTemplate = "user.sql")
public class UserInfo extends Model<UserInfo>{

	private static final long serialVersionUID = 1L;
	
}
