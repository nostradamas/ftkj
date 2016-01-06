package com.qd.ftkj.website.dao;

import java.util.List;

import com.qd.ftkj.website.model.InfoBean;

public interface WebsiteDao {
	
	public List<InfoBean> getInfoList(String infotype, int page, int limit);

	public int getCount(String infotype);
	
	public List<InfoBean> getPicInfoList(String infotype, int page, int limit);

	public int getPicCount(String infotype);
}
