package com.bookstore.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {
	
	//将yyyy-MM-dd格式的字符串转换为日期
	public static Date convertToDate(String dateStr) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	//将用户指定格式的字符串转换为日期
	public static Date convertToDate(String dateStr, String pt) {
		DateFormat df = new SimpleDateFormat(pt);
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	//将日期转换为yyyy-MM-dd格式的字符串
	public static String convertToString(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = null;
		dateStr = df.format(date);
		return dateStr;
	}
	
	//将日期转换为指定格式的字符串
	public static String convertToString(Date date, String pt) {
		DateFormat df = new SimpleDateFormat(pt);
		String dateStr = null;
		dateStr = df.format(date);
		return dateStr;
	}
}
