package com.itshcool.kit;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 扫描包路径
 */

@SuppressWarnings("all")
public class FileScanKit {

	private Class annotation;

	private String packName;

	/**
	 * @param annotation
	 *            注解过滤
	 * @param packName
	 *            扫描的根目录
	 */
	public FileScanKit(Class annotation, String packName) {
		this.annotation = annotation;
		this.packName = packName;
	}

	/**
	 * 扫描包
	 */
	public List<Class<?>> scanPackage() {
		List<Class<?>> clazzs = new ArrayList<>();
		String packageDirName = packName.replace('.', '/');
		Enumeration<URL> dirs;
		try {
			URL url = Thread.currentThread().getContextClassLoader().getResource(packageDirName);
			String protocol = url.getProtocol();
			if ("file".equals(protocol)) {// 扫描file包中的类
				String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
				scanClass(packName, filePath, clazzs);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return clazzs;
	}

	/**
	 * 获取文件中的class
	 */
	private void scanClass(String packName, String filePath, List<Class<?>> clazzs) {
		File dir = new File(filePath);
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("包目录不存在!");
			return;
		}
		File[] dirFiles = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				boolean acceptDir = file.isDirectory();// 接受dir目录
				boolean acceptClass = file.getName().endsWith(".class");// 接受class文件
				return acceptDir || acceptClass;
			}
		});
		for (File file : dirFiles) {
			if (file.isDirectory()) {
				scanClass(packName + "." + file.getName(), file.getAbsolutePath(), clazzs);
			} else {
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					Class<?> clazz = Thread.currentThread().getContextClassLoader()
							.loadClass(packName + "." + className);
					// 包含指定注解才添加
					if (clazz.isAnnotationPresent(annotation)) {
						clazzs.add(clazz);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}