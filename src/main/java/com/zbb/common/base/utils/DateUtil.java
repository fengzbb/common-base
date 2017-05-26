package com.zbb.common.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:时间工具类
 * @author zbb
 * @date 2017年5月26日 下午3:07:44
 */
public class DateUtil {
	
	public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss SSS";
	
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	
	public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
	
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	public static final String YYYYMMDD = "yyyyMMdd";
	
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	
	public static final String YYYY_NIAN_MM_YUE_DD_RI_HH_MM_SS = "yyyy��MM��dd�� HH:mm:ss";
	
	
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
	
	/**
	 * �������ڻ������
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekDaysName = { "����", "��һ", "�ܶ�", "����", "����", "����", "����" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysName[intWeek];
	}
	
	/**
	 * ����������
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addByMinutes(Date date, int amount) {
		return add(date, Calendar.MINUTE, amount);
	}
	
	/**
	 * ����Сʱ��
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addByHours(Date date, int amount) {
		return add(date, Calendar.HOUR_OF_DAY, amount);
	}
	
	/**
	 * ��������
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addByDays(Date date, int amount) {
		return add(date, Calendar.DAY_OF_MONTH, amount);
	}

	public static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}
	
	
	public static void main(String[] args) {
		String s = "2017-04-04";
//		String s1 = "2017-04-04";
		Date date1 = DateUtil.parseDate(s, DateUtil.YYYY_MM_DD);
//		Date date2 = DateUtil.parseDate(s1, DateUtil.YYYY_MM_DD);
//		
//		System.out.println(DateUtil.isBefore(date1, date2));
//		System.out.println(DateUtil.isAfter(date2, date1));
		System.out.println(DateUtil.formatDate(DateUtil.addByDays(date1, -10), DateUtil.YYYY_MM_DD));
		
	}
	
	
}
