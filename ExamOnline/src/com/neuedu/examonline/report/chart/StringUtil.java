package com.neuedu.examonline.report.chart;

import java.io.UnsupportedEncodingException;

public class StringUtil {

	public static String nullWithNone(String para) {
		if (para == null) {
			para = "";
		}
		return para;
	}

	public static String nullWithHtmlSpace(String para) {
		if (para == null) {
			para = "&nbsp;";
		}
		return para;
	}

	public static String iSOToUtf8(String para) {
		String result = "";
		if (para == null)
			para = "";
		try {
			if (para != null) {
				result = new String(para.getBytes("iso-8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result.trim();
	}

	public static String Utf8ToIso(String para) {
		String result = "";
		if (para == null)
			para = "";
		try {
			if (para != null) {
				result = new String(para.getBytes("utf-8"), "iso-8859-1");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result.trim();
	}
	//首字母转小写
    public static String toLowerCaseFirstOne(String s)
    {
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    //首字母转大写
    public static String toUpperCaseFirstOne(String s)
    {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
