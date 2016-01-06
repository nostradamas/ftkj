package com.qd.ftkj.website.dao;

import javax.annotation.Resource;

import com.qd.ftkj.website.utils.DbUtilsTemplate;


public class BaseImpl {
	/**
	 * 视图
	 */
	protected final static String VIEW_INFO = "V_INFOLIST";
	
	protected final static String VIEW_PICINFO = "V_PICNEWS";
	
	/**
	 * 数据表
	 */
	protected final static String TABLE_WEBSITEINFO = "T_CMS_SITE_INFO";

	@Resource
	protected DbUtilsTemplate mDbUtils;

	public void setDbUtilsTemplate(DbUtilsTemplate dbUtilsTemplate) {
		mDbUtils = dbUtilsTemplate;
	}
}
