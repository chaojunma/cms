package com.itshcool.service;

import java.util.List;
import com.itshcool.model.Classify;
import com.itshcool.param.ClassifyQueryParam;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

public class ClassifyService {
	
	private static final Classify dao = new Classify();

	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	public Page<Classify> list(ClassifyQueryParam param){
    	Kv para = Kv.by("name", param.getName())
    			                .set("order", param.getOrder())
    			                .set("createTime", param.getCreateTime());
    	SqlPara sqlPara = Db.getSqlPara("classify.findByPage", para);
    	return dao.paginate(param.getPage(), param.getLimit(), sqlPara);
    }
	
	
	/**
	 * 查询全部
	 */
	public List<Classify> findAll(){
		return dao.find("select * from classify");
	}
	
	
	/**
	 * 根据主键ID删除
	 * @param id
	 * @return
	 */
	public boolean deleteById(int id){
		return dao.deleteById(id);
	}
}
