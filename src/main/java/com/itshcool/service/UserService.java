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
    	Kv para = Kv.by("key", param.getKey())
    			                .set("order", param.getOrder())
    			                .set("createTime", param.getCreateTime())
    			                .set("isLock", param.getIsLock());
    	SqlPara sqlPara = Db.getSqlPara("user.findByPage", para);
    	return dao.paginate(param.getPage(), param.getLimit(), sqlPara);
    }
    
    
    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    public UserInfo findById (int id){
    	return dao.findById(id);
    }
    
    
    /**
     * 保存或更新
     * @return
     */
    public void saveOrUpdate(UserInfo user){
    	if(user.get("id") != null){
    		user.update();
    	} else {
    		user.save();
    	}
    }
    
}
