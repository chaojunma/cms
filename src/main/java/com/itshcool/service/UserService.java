package com.itshcool.service;

import com.itshcool.model.UserInfo;
import com.itshcool.param.UserQueryParam;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

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
    
    
    /**
     * 分页查询
     * @return
     */
    public Page<UserInfo> list(UserQueryParam param){
    	Kv para = Kv.by("userName", param.getUserName())
    			                .set("orderStr", param.getOrder());
    	SqlPara sqlPara = Db.getSqlPara("user.findByPage", para);
    	return dao.paginate(param.getPage(), param.getLimit(), sqlPara);
    }
    
}
