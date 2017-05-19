package com.zbb.common.base.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 加载配置文件内容，
 * @Description:
 * @author zbb
 * @date 2017年5月19日 下午2:18:41
 */
public class LoadPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private static Map<String, Object> propertiesMap = new HashMap<String, Object>(); 
	 
    @Override 
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException { 
        super.processProperties(beanFactoryToProcess, props);
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr); 
            propertiesMap.put(keyStr, value); 
        }
    } 
 
    @SuppressWarnings("all")
	public static <T> T getContextProperty(String key) {
        return (T)propertiesMap.get(key); 
    } 
    
    @SuppressWarnings("all")
    public void reload(){
    	try{
    		Properties result = mergeProperties();
    		HashMap map =new HashMap<String, Object>();
    		map.putAll(result);
    		propertiesMap=map;
    	}catch(Exception e){
    		logger.error("reload properties error!",e);
    	}
    }
}
