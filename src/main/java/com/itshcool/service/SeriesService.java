package com.itshcool.service;

import com.itshcool.model.ClassSeries;
import com.itshcool.param.PageParam;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

public class SeriesService {
	
	private static final ClassSeries dao = new ClassSeries();
	
	
	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	public Page<ClassSeries> list(PageParam param){
    	Kv para = Kv.by("key", param.getKey())
    			                .set("order", param.getOrder())
    			                .set("createTime", param.getCreateTime());
    	SqlPara sqlPara = Db.getSqlPara("series.findByPage", para);
    	return dao.paginate(param.getPage(), param.getLimit(), sqlPara);
    }
	
	
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	public boolean deleteById(int id){
		return dao.deleteById(id);
	}
	
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int[] batchDelete(String[] ids) {
		Object[][] paras = new Object[ids.length][1];
		for (int i = 0; i < ids.length; i++) {
			paras[i][0] = ids[i];
		}
		String sql = "delete from class_series where id in(?)";
		return Db.batch(sql, paras, ids.length);
	}
}
