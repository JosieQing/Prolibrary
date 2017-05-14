package com.neusoft.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author zhangjun
 * 2013-7-28 上午08:58:23
 * 这个类主要作用是读取配置文件
 */
public class PropertyUtil {

	private Properties prop;
	private static PropertyUtil propertyUtil = null;
	private Log logger = LogFactory.getLog(PropertyUtil.class);
	
	private PropertyUtil() {
	}
	
	public static PropertyUtil getInstance() {
		if (propertyUtil == null) {
			propertyUtil = new PropertyUtil();
		}
		return propertyUtil;
	}
	
	/**
	 * 读取服务器配置文件
	 */
	public Properties getProperty(String path) {
		if (logger.isDebugEnabled()) {
			logger.debug("读取配置文件:" + path);
		}
		prop = new Properties();
//		BufferedInputStream in;
		try {
//			in = new BufferedInputStream(new FileInputStream(path));
//			prop.load(in);
			prop.load(this.getClass().getClassLoader().getResourceAsStream(
			"datainfo.properties"));
		} catch (FileNotFoundException e) {
			if (logger.isErrorEnabled()) {
				logger.error("找不到配置文件", e);
			}
		} catch (IOException e) {
			if (logger.isErrorEnabled()) {
				logger.error("读取文件失败", e);
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("读取配置文件成功");
		}
		return prop;
	}
}

