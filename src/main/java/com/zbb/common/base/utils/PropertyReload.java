package com.zbb.common.base.utils;


import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ÿ5�������¼���һ�������ļ�����
 * @Description:
 * @author zbb
 * @date 2017��5��19�� ����2:20:13
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
