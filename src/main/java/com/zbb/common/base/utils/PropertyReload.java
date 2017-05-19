package com.zbb.common.base.utils;


import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 每5分钟重新加载一次配置文件内容
 * @Description:
 * @author zbb
 * @date 2017年5月19日 下午2:20:13
 */
@Component
public class PropertyReload {

	@Resource()
	private LoadPropertyPlaceholderConfigurer loadPropertyPlaceholderConfigurer;
	
	@Scheduled(initialDelay = 5 * 60 * 1000,fixedDelay = 5 * 60 * 1000)
    public void reload(){
		loadPropertyPlaceholderConfigurer.reload();
	}

	
}
