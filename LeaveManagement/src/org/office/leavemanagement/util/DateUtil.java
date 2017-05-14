package org.office.leavemanagement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String Y_M_D = "yyyy-MM-dd";
	public static final String Y_M_D_HM = "yyyy-MM-dd HH:mm";
	public static final String Y_M_D_HMS = "yyyy-MM-dd HH:mm:ss";
	public static final String YMD = "yyyyMMdd";
	public static final String YMDHM = "yyyyMMddHHmm";
	public static final String YMDHMS = "yyyyMMddHHmmss";
	public static final String ymd = "yyyy/MM/dd";
	public static final String ymd_HM = "yyyy/MM/dd HH:mm";
	public static final String ymd_HMS = "yyyy/MM/dd HH:mm:ss";

	public static String format(Date date, String style) {
		String result = null;
		try {
			if (date == null) {
				date = new Date();
			}
			if (style == null || "".equals(style)) {
				style = Y_M_D;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(style);
			result = sdf.format(date).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getCurrentYear() {
		Calendar now = Calendar.getInstance();
		int y = now.get(Calendar.YEAR);
		return String.valueOf(y);
	}

	public static String getCurrentMonth() {
		Calendar now = Calendar.getInstance();
		int m = now.get(Calendar.MONTH);
		return String.valueOf(m + 1);
	}

	public static String getLastDayByYM(int y, int m) {
		String d = "";
		if (m == 1) {
			d = "31";
		} else if (m == 2) {
			if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
				d = "29";
			} else {
				d = "28";
			}
		} else if (m == 3) {
			d = "31";
		} else if (m == 4) {
			d = "30";
		} else if (m == 5) {
			d = "31";
		} else if (m == 6) {
			d = "30";
		} else if (m == 7) {
			d = "31";
		} else if (m == 8) {
			d = "31";
		} else if (m == 9) {
			d = "30";
		} else if (m == 10) {
			d = "31";
		} else if (m == 11) {
			d = "30";
		} else if (m == 12) {
			d = "31";
		}
		return d;
	}
	
	public static Date string2Date(String strDate,String style){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}

}
