package com.qd.ftkj.website.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qd.ftkj.website.dao.BaseImpl;
import com.qd.ftkj.website.dao.WebsiteDao;
import com.qd.ftkj.website.model.InfoBean;

/**
 * 网站数据操作实现
 * 
 * @author chengl
 *
 */
@Repository
public class WebsiteImpl extends BaseImpl implements WebsiteDao {

	// 根据栏目Id获取新闻列表
	@Override
	public List<InfoBean> getInfoList(String infotype, int page, int limit) {
		
		/**
		 * blic class InfoBean {
	private String url;
	private String infotype;
	private String insertDate;
	private String infoname;
		 */
		String sql = "SELECT t1.guid,t1.ymjtdz as url,"
				+ "CONVERT(varchar(12),t1.cjsj,111) as insertDate,t1.infotype,t1.infoname FROM " 
				+ VIEW_INFO + " t1,("
				+ "SELECT TOP " + limit + " guid FROM ("
				+ "   SELECT TOP " + limit*(page+1)+ " guid,cjsj FROM " + VIEW_INFO +" where infotype = ? "
				+ " ORDER BY cjsj DESC,guid DESC) t ORDER BY cjsj ASC,guid ASC"
				+ ") t2 WHERE t1.guid = t2.guid and shzt = '100' ORDER BY cjsj DESC,guid DESC";
		System.out.println("sql"+sql);
		return mDbUtils.find(InfoBean.class, sql, new Object[] {infotype});
	}

	@Override
	public int getCount(String infotype) {
		String sql = "SELECT COUNT (*) FROM " + VIEW_INFO + " t1"
				+ " WHERE shzt = '100' AND infotype = ? ";
		Integer i = (Integer) mDbUtils.findBy(sql, 1, new Object[] {infotype});
		int size = 0;
		if (i != null) {
			size = i.intValue();
		}
		return size;
	}
	
	// 根据栏目Id获取图片新闻列表
	@Override
	public List<InfoBean> getPicInfoList(String infotype, int page, int limit) {
		String sql = "SELECT t1.guid,t1.ymjtdz as url,"
				+ "CONVERT(varchar(12),t1.cjsj,111) as insertDate,t1.infotype,t1.url FROM " 
				+ VIEW_PICINFO + " t1,("
				+ "SELECT TOP " + limit + " guid FROM ("
				+ "   SELECT TOP " + limit*(page+1)+ " guid,cjsj FROM " + VIEW_PICINFO + " where infotype = ? "
				+ " ORDER BY cjsj DESC,guid DESC) t ORDER BY cjsj ASC,guid ASC"
				+ ") t2 WHERE t1.guid = t2.guid and shzt = '100' ORDER BY cjsj DESC,guid DESC";
		System.out.println("sql"+sql);
		return mDbUtils.find(InfoBean.class, sql, new Object[] {infotype});
	}

	@Override
	public int getPicCount(String infotype) {
		String sql = "SELECT COUNT (*) FROM " + VIEW_PICINFO + " t1"
				+ " WHERE shzt = '100' AND infotype = ? ";
		Integer i = (Integer) mDbUtils.findBy(sql, 1, new Object[] {infotype});
		int size = 0;
		if (i != null) {
			size = i.intValue();
		}
		return size;
	}
	
}
