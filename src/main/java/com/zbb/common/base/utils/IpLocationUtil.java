package com.zbb.common.base.utils;

import java.util.HashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * 根据ip地址获取省份
 * @Description:
 * @author zbb
 * @date 2017年5月19日 下午3:26:30
 */
public class IpLocationUtil {

	private static Logger logger = LoggerFactory.getLogger(IpLocationUtil.class);
	
	//百度开放平台密钥
	private static final String BAIDU_LOCATION_KEY = "tPhNm3k9msoHmBjGPq9DLZNF";

	//获取省份名称
	public static String[] getFullLocationName(String ipAddr) {
		JSONObject data = null;
		try {
			data = getDataFromBaiduLocationApi(ipAddr);
		} catch (Exception e) {
			return null;
		}
		String province = null;
		String city = null;
		if (data != null) {
			JSONObject addressDetail = data.getJSONObject("address_detail");
			province = addressDetail.getString("province");
			city = addressDetail.getString("city");
		}
		return new String[]{province,city};
	}
	
	private static JSONObject getDataFromBaiduLocationApi(String ip) throws Exception{
		String baiduLocationApi = "http://api.map.baidu.com/location/ip?ak=" + BAIDU_LOCATION_KEY + "&ip=" + ip;
		
		String content = null;
		try {
//			content = HttpsUtil.requestGet(baiduLocationApi);
			JSONObject jsonObject = JSONObject.fromObject(content);
			Integer code = (Integer) jsonObject.get("status");
			if (code != null && code == 0) {
				JSONObject data = jsonObject.getJSONObject("content");
				return data;
			} else {
				logger.warn("get location by ip (baiduapi) fail. baidu code is: " + code+";ip:"+ip);
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
			throw e;
		}
		return null;
	}
	
	public static void main(String[] args){
		String ips [] = new String[]{"114.80.166.240","58.51.60.97","61.180.77.143","218.22.10.216","59.69.160.0","59.75.52.59","222.75.147.54","221.207.26.76","59.75.176.0","61.178.2.0","218.88.223.255","221.3.131.13","222.86.188.148","222.177.117.73","220.182.50.226","121.14.212.72","218.204.14.50","220.168.0.79","113.52.64.0","114.142.153.196","218.5.5.49","163.19.9.247","218.77.129.198","219.134.158.131","220.181.38.49","59.48.8.182","222.222.24.30","221.239.32.28","123.172.144.1","113.225.183.144","125.211.216.199","218.21.128.125","58.59.26.157","125.122.139.124","221.229.118.44"};
		String loc [] = new String[]{"上海","湖北","江西","安徽","河南","陕西","宁夏","青海","新疆","甘肃","四川","云南","贵州","重庆","西藏","广东","广西","湖南","澳门","香港","福建","台湾","海南","深圳","北京","山西","河北","天津","吉林","辽宁","黑龙江","内蒙","山东","浙江","江苏"};
		Map<Long, String> map = new HashMap<Long, String>();
		map.put(1L, "北京");
		map.put(79L, "上海");
		map.put(82L, "南京");
		map.put(100L, "杭州");
		map.put(229L, "广州");
		map.put(231L, "深圳");
		map.put(279L, "成都");
		int i = 0;
		for (String ip : ips) {
			long start = System.currentTimeMillis();
			System.out.println("ip:" + ip);
			String[] fullName = IpLocationUtil.getFullLocationName(ip);
			System.out.println("省份:" + loc[i]);
			
			System.out.println("province:" + fullName[0]);
			System.out.println("city:" + fullName[1]);
			long end = System.currentTimeMillis();
			System.out.println("执行一次时间" + (end - start));
			System.out.println("-------------------------");
			i++;
			
		}
	}
	
}
