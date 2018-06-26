package com.itshcool.routes;

import java.lang.annotation.Annotation;
import java.util.List;
import com.itshcool.annotation.JAction;
import com.itshcool.kit.FileScanKit;
import com.jfinal.config.Routes;

@SuppressWarnings("all")
public class AutoBindRoutes extends Routes{

	/**
     * controller扫描的包
     */
    private String packName;
    /**
     * 视图基本目录
     */
    private String baseViewPath;

    public AutoBindRoutes(String packName) {
        this.packName = packName;
    }

    public AutoBindRoutes(String packName, String baseViewPath) {
        this.packName = packName;
        this.baseViewPath = baseViewPath;
    }

	@Override
	    public void config() {
	        if (baseViewPath != null) {
	            setBaseViewPath(baseViewPath);
	        }
	        //过滤
	        FileScanKit fileScanKit = new FileScanKit(JAction.class, packName);
	        List<Class<?>> controllers = fileScanKit.scanPackage();
	        //循环controller,绑定路由
	        for (Class controller : controllers) {
	            //获取注解上的内容
	            Annotation annotation = controller.getAnnotation(JAction.class);
	            JAction jAction = (JAction) annotation;
	            String url = jAction.value();
	            String viewPath = jAction.viewPath();
	            //绑定路由
	            add(url, controller, viewPath);
	        }
	    }

}
