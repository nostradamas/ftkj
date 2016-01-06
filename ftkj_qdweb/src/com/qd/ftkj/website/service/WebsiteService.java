package com.qd.ftkj.website.service;

import com.qd.ftkj.website.result.ListResult;
import com.qd.ftkj.website.result.ObjectResult;

/**
 * 首页操作
 * @author chengl
 *
 */
public interface WebsiteService {
	
	/**
	 * 获取对应类型栏目列表
	 * @param infotype 栏目
	 * @param limit 显示行数
	 * @param page  第几页
	 * @param ispic  是否是图片新闻还是文字新闻
	 * @return
	 */
	public ListResult<?> getInfoList(String infotype, int page, int limit, int ispic);
	
	/**
	 * 获取新闻信息
	 * @param pid
	 * @return
	 */
	public ObjectResult getNewsHtml(String pid);
}
