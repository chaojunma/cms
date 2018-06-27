package com.itshcool.service;

import com.itshcool.model.UserInfo;
import com.jfinal.plugin.activerecord.Db;

/**
 * 用户服务
 * @author chaojunma
 * @date 2018年6月26日
 */
public class UserService {
	
	private static final UserInfo dao = new UserInfo();
	
	/**
     * 查询
     */
    public UserInfo findByName(String userName, String password) {
    	String sql = Db.getSql("user.findByName");
    	return dao.findFirst(sql, userName, password);
    }
}
