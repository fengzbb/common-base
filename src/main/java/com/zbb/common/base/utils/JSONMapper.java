package com.zbb.common.base.utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * json 序列化反序列化实例
 * Inclusion.NON_NULL :NULL或者为空不参加序列化
 * FAIL_ON_UNKNOWN_PROPERTIES :有属性不能映射的时候不报错
 * @Description:
 * @author zbb
 * @date 2017年5月19日 下午7:09:55
 */
@SuppressWarnings("deprecation")
public class JSONMapper {
	private static ObjectMapper mapper = new ObjectMapper();
	static{
		mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);  
		mapper.getDeserializationConfig().set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	}
	public static ObjectMapper getInstance(){
		return mapper;
	}
}
