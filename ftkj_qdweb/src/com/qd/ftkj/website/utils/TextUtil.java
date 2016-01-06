package com.qd.ftkj.website.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TextUtil {
	/**
	 * 字符串是否为空，空包括null，或者除去头尾空格后为空字符串
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isEmpty(String v) {
		if (v == null)
			return true;
		if (v.trim().length() == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public static String formatNum(int v) {
		if (v < 10) {
			return "000" + v;
		} else if (v < 100) {
			return "00" + v;
		} else if (v < 1000) {
			return "0" + v;
		} else {
			return String.valueOf(v);
		}
	}

	/**
	 * 
	 * @param format
	 * @param d
	 * @return
	 */
	public static String formatDate(String format, Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

}
