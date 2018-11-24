package com.zbb.common.base.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Description: 读取配置文件 定时读取(采用spring的定时任务)
 * @Author: zbb
 * @Date: 2018/1/2 15:07
 */

public class LoadPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private static Map<String, Object> propertiesMap = new HashMap<>();

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
        return (T) propertiesMap.get(key);
    }

    @SuppressWarnings("all")
    public void reload() {
        try {
            Properties result = mergeProperties();
            HashMap map = new HashMap<String, Object>();
            map.putAll(result);
            propertiesMap = map;
        } catch (Exception e) {
            logger.error("reload properties error!", e);
        }
    }
}
