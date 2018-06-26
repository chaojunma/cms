package com.itshcool.pluigin;

import java.lang.annotation.Annotation;
import java.util.List;
import com.itshcool.annotation.JTable;
import com.itshcool.kit.FileScanKit;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.IPlugin;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * 扫描插件
 */
@SuppressWarnings("all")
public class ScanTablePluigin implements IPlugin {
	
    private ActiveRecordPlugin arp;
    /**
     * 注解扫描包
     */
    private String packName;

    /**
     * 数据源名称
     */
    private String dbName = JTable.DB_NAME;

    /**
     * 基本sql目录路径
     */
    private String baseSqlTemplatePath;

    public ScanTablePluigin(ActiveRecordPlugin arp, String packName) {
        this.arp = arp;
        this.packName = packName;
    }

    public ScanTablePluigin(ActiveRecordPlugin arp, String packName, String dbName) {
        this.arp = arp;
        this.packName = packName;
        this.dbName = dbName;
    }

    @Override
    public boolean start() {
        //过滤注解
        FileScanKit kit = new FileScanKit(JTable.class, packName);
        List<Class<?>> tables = kit.scanPackage();
        //sql管理
        if (StrKit.notBlank(baseSqlTemplatePath)) {
            arp.setBaseSqlTemplatePath(baseSqlTemplatePath);
        } else {
            //默认为根路径
            arp.setBaseSqlTemplatePath(PathKit.getRootClassPath());
        }
        //扫描
        for (Class table : tables) {
            //获取参数
            Annotation annotation = table.getAnnotation(JTable.class);
            JTable jTable = (JTable) annotation;
            //数据源名称
            String dbName = jTable.dbName();
            if (dbName.equals(this.dbName)) {
                //添加到mapping中
                arp.addMapping(jTable.tableName(), jTable.id(), table);
                //sql路径
                String sqlTemplate = jTable.sqlTemplate();
                if (StrKit.notBlank(sqlTemplate)) {
                    arp.addSqlTemplate(sqlTemplate);
                }
            }
        }
        return true;
    }

    @Override
    public boolean stop() {
        return true;
    }


    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getBaseSqlTemplatePath() {
        return baseSqlTemplatePath;
    }

    public void setBaseSqlTemplatePath(String baseSqlTemplatePath) {
        this.baseSqlTemplatePath = baseSqlTemplatePath;
    }
}
