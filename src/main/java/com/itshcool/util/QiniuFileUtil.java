package com.itshcool.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.apache.commons.codec.binary.Base64;
import com.jfinal.kit.PropKit;
import com.jfinal.upload.UploadFile;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.util.Auth;

/**
 * 七牛云工具类
 * @author chaojunma
 * @date 2018年7月4日
 */
public class QiniuFileUtil {

	/***
	 * 普通上传图片
	 * 
	 * @param file
	 * @return
	 * @throws QiniuException
	 * @throws IOException
	 */
	public static String upload(UploadFile file) throws IOException, NoSuchAlgorithmException {
		Zone z = Zone.zone0();
		Configuration config = new Configuration(z);
		String fileName = null;
		String extName = null; 
		if (file != null) {
			extName = file.getFileName().substring(file.getFileName().lastIndexOf("."));
			fileName = UUID.randomUUID().toString().toString().replace("-", "")+ extName;
			UploadManager uploadManager = new UploadManager(config);
			Auth auth = Auth.create(PropKit.get("qiniuAccess"), PropKit.get("qiniuKey"));
			String token = auth.uploadToken(PropKit.get("bucketName"));
			Response r = uploadManager.put(file.getFile().getAbsolutePath(), fileName, token);
			if (r.isOK()) {
				System.out.println("文件上传成功");
			}
		}
		return fileName;
	}
	
	
	/***
	 * 删除已经上传的图片
	 * @param imgPath
	 */
	public static void deleteQiniuP(String imgPath) {
		Zone z = Zone.zone0();
		Configuration config = new Configuration(z);
		Auth auth = Auth.create(PropKit.get("qiniuAccess"), PropKit.get("qiniuKey"));
		BucketManager bucketManager = new BucketManager(auth,config);
		imgPath = imgPath.replace(PropKit.get("path"), "");
		try {
			bucketManager.delete(PropKit.get("bucketName"), imgPath);
		} catch (QiniuException e) {
			e.printStackTrace();
		}
	}

	/***
	 * 上传网络图片
	 * @param src
	 * @return
	 */
	public static String uploadImageSrc(String src){
		Zone z = Zone.zone0();
		Configuration config = new Configuration(z);
		Auth auth = Auth.create(PropKit.get("qiniuAccess"), PropKit.get("qiniuKey"));
		BucketManager bucketManager = new BucketManager(auth, config);
		String filePath="";
		try {
			FetchRet fetchRet = bucketManager.fetch(src, PropKit.get("bucketName"));
			filePath = PropKit.get("path") + fetchRet.key;
		} catch (QiniuException e) {
			filePath = src;
			e.printStackTrace();
		}
		return filePath;
	}

	/***
	 * 上传本地图片
	 * @param src
	 * @return
	 */
	public static String uploadLocalImg(String src) throws IOException, NoSuchAlgorithmException{
		Zone z = Zone.zone0();
		Configuration config = new Configuration(z);
		UploadManager uploadManager = new UploadManager(config);
		Auth auth = Auth.create(PropKit.get("qiniuAccess"), PropKit.get("qiniuKey"));
		String token = auth.uploadToken(PropKit.get("bucketName"));
		File file = new File(src);
		if(!file.exists()){
			System.out.println("文件不存在");
		}
		String filePath = null;
		String name = UUID.randomUUID().toString();
		Response response = uploadManager.put(file,name,token);
		if(response.isOK()){
			filePath = PropKit.get("path") + name;
			System.out.println("上传成功");
		}
		return filePath;
	}

	/**
	 * 上传base64位的图片
	 * @param base64
	 * @return
	 */
	public static String uploadBase64(String base64,String name) {
		Zone z = Zone.zone0();
		Configuration config = new Configuration(z);
		UploadManager uploadManager = new UploadManager(config);
		Auth auth = Auth.create(PropKit.get("qiniuAccess"), PropKit.get("qiniuKey"));
		String token = auth.uploadToken(PropKit.get("bucketName"));
		String filePath = null;
		byte[] data = Base64.decodeBase64(base64);
		try {
			uploadManager.put(data,name,token);
		} catch (IOException e) {
			e.printStackTrace();
		}
		filePath = PropKit.get("path")+name;
		return filePath;
	}
	
	
	public static String publicFile(String fileName,String domainOfBucket) {  
	    String encodedFileName=null;  
	    try {  
	        encodedFileName = URLEncoder.encode(fileName, "utf-8");  
	    } catch (UnsupportedEncodingException e) {  
	        e.printStackTrace();  
	    }  
	    String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);  
	    return finalUrl;  
	} 
}
