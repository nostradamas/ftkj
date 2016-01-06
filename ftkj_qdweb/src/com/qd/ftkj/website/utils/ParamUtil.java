package com.qd.ftkj.website.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;

/**
 * 参数处理工具类
 * 
 */
public class ParamUtil {
	/**
	 * 处理int
	 * 
	 * @param value
	 * @param def
	 * @return
	 */
	public static int toInt(String value, int def) {
		if (value == null)
			return def;
		int r = def;
		try {
			r = Integer.valueOf(value);
		} catch (Exception e) {
		}
		return r;
	}

	/**
	 * 处理字符型
	 * 
	 * @param value
	 * @param def
	 * @return
	 */
	public static String toString(Object value, String def) {
		if (value == null)
			return def;
		return String.valueOf(value);
	}

	public static String toStringToUtf8(Object value, String def) {
		if (value == null)
			return def;
		try {
			return new String(String.valueOf(value).getBytes("iso-8859-1"),
					"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return def;
	}

	public static <T> T toObject(InputStream is, Class<T> c) {
		ByteArrayBuffer bab = new ByteArrayBuffer();
		try {
			bab.write(is);
			byte[] buf = bab.getRawData();
			JSONArray ja = new JSONArray(new String(buf));
			if (ja.length() > 0) {
				JSONObject obj = ja.getJSONObject(0);
				return new Gson().fromJson(obj.toString(), c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bab != null)
					bab.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}
