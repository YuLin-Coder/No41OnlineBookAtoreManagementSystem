package com.bookstore.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {
	
	//��yyyy-MM-dd��ʽ���ַ���ת��Ϊ����
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
	
	//���û�ָ����ʽ���ַ���ת��Ϊ����
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
	
	//������ת��Ϊyyyy-MM-dd��ʽ���ַ���
	public static String convertToString(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = null;
		dateStr = df.format(date);
		return dateStr;
	}
	
	//������ת��Ϊָ����ʽ���ַ���
	public static String convertToString(Date date, String pt) {
		DateFormat df = new SimpleDateFormat(pt);
		String dateStr = null;
		dateStr = df.format(date);
		return dateStr;
	}
}
