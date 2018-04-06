package com.dt59.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * ���ַ�������ת�������ڸ�ʽ
 * */
public class CastDateUtil {
	/**
	 * @param  str:�ַ�����ʽ
	 * @return Date��ʽ
	 * */
	public static Date getDateFormat(String str){
		Date date=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			date=sdf.parse(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;
	}
}
