package com.zbb.common.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:ʱ�乤����
 * @author zbb
 * @date 2017��4��10�� ����10:53:03
 */
public class DateUtil {
	
	public static final String YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd HH:mm:ss S";
	
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	public static final String YYYYMMDD = "yyyyMMdd";
	
	
	/**
	 * ��String��ʽ�ַ���ת�����ض���ʽ��ʱ��
	 * @param strDate
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String strDate, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * ��ʱ���ʽת�����ض���ʽ���ַ���ʱ��
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * ��long��ʽ��ʱ��ת�����ض���ʽ���ַ���ʱ��
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Long time, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date(time));
	}
	
	/**
	 * date1 ���� date2
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Boolean isBefore(Date date1,Date date2){
		return date1.before(date2);
	}
	
	/**
	 * date1 ���� date2
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Boolean isAfter(Date date1,Date date2){
		return date1.after(date2);
	}
	
	public static void main(String[] args) {
		String s = "2017-04-04";
		String s1 = "2017-04-04";
		Date date1 = DateUtil.parseDate(s, DateUtil.YYYY_MM_DD);
		Date date2 = DateUtil.parseDate(s1, DateUtil.YYYY_MM_DD);
		
		System.out.println(DateUtil.isBefore(date1, date2));
		System.out.println(DateUtil.isAfter(date2, date1));
		
	}
	
	
}
