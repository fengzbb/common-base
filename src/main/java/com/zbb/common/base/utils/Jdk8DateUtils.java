package com.zbb.common.base.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * jdk8操作时间类型
 * @Description:
 * @author zbb
 * @date 2017年8月24日 上午1:06:20
 */
public class Jdk8DateUtils {
	
	public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss SSS";
	
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	
	public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
	
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	public static final String YYYYMMDD = "yyyyMMdd";
	
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	
	public static final String YYYY_NIAN_MM_YUE_DD_RI_HH_MM_SS = "yyyy年MM月dd日 HH:mm:ss";
	
	
	/**
	 * 将LocalDateTime转成特定格式的string
	 * @param localDateTime
	 * @param partern
	 * @return
	 */
	public static String formatDate(LocalDateTime localDateTime, String partern){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(partern);
		return localDateTime.format(dtf).toString();
	}
	
	/**
	 * 按天累加
	 * @param localDateTime
	 * @param amount
	 * @return
	 */
	public static LocalDateTime addByDays(LocalDateTime localDateTime, int amount){
		LocalDateTime plusDays = localDateTime.plusDays(amount);
		return plusDays;
	}
	
	/**
	 * 按hour累加
	 * @param localDateTime
	 * @param amount
	 * @return
	 */
	public static LocalDateTime addByHours(LocalDateTime localDateTime, int amount){
		LocalDateTime plusHours = localDateTime.plusHours(amount);
		return plusHours;
	}
	
	/**
	 * 按s累加
	 * @param localDateTime
	 * @param amount
	 * @return
	 */
	public static LocalDateTime addBySeconds(LocalDateTime localDateTime, int amount){
		LocalDateTime plusSeconds = localDateTime.plusSeconds(amount);
		return plusSeconds;
	}
	
	/**
	 * 两时间相差天数
	 * @param localDateTime1
	 * @param localDateTime2
	 * @return
	 */
	public static long betweenDays(LocalDateTime localDateTime1, LocalDateTime localDateTime2){
		long betweenDays = ChronoUnit.DAYS.between(localDateTime1, localDateTime2);
		return betweenDays;
	}
	
	/**
	 * 将date 转成 LocalDateTime
	 * @param date
	 * @return
	 */
	public static LocalDateTime dateToLocalTime(Date date){
		Instant instant = date.toInstant();
		ZoneId systemDefault = ZoneId.systemDefault();
		LocalDateTime localDateTime = instant.atZone(systemDefault).toLocalDateTime();
		return localDateTime;
	}
	
	public static void main(String[] args) {
		LocalDateTime local = LocalDateTime.parse("2017-07-20T00:00:00");
		local = addBySeconds(local, -1);
		String formatDate = formatDate(local,Jdk8DateUtils.YYYY_MM_DD_HH_MM_SS);
		System.out.println("now--"+formatDate);
		
		long between = ChronoUnit.DAYS.between(local, local);
		System.out.println(between);
		
		LocalDateTime dateToLocalTime = dateToLocalTime(new Date(1503000859247L));
		System.out.println(dateToLocalTime);
	}

}
