package com.qd.ftkj.website.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qd.ftkj.website.dao.WebsiteDao;
import com.qd.ftkj.website.model.InfoBean;
import com.qd.ftkj.website.result.ListResult;
import com.qd.ftkj.website.result.ObjectResult;
import com.qd.ftkj.website.service.WebsiteService;

@Service("websiteServiceImpl")
public class WebsiteServiceImpl implements WebsiteService{

	@Resource
	private WebsiteDao websitedao;
	@Override
	public ListResult<?> getInfoList(String infotype, int page, int limit,int ispic) {
		ListResult<InfoBean> res = new ListResult<InfoBean>();
		List<InfoBean> infolist = new ArrayList<InfoBean>();
		int infosize = 0;
		if(ispic==0){// 文字新闻
			infolist = websitedao.getInfoList(infotype, page ,limit);
			infosize = websitedao.getCount(infotype);
		} else {
			infolist = websitedao.getPicInfoList(infotype, page ,limit);
			infosize = websitedao.getPicCount(infotype);
		}
		System.out.println("查询总行数："+infosize);
		res.setData(infolist);
		res.setTotalSize(infosize);
		res.setPage(page);
		res.setPagesize(infosize/(limit)+1);
		res.setHasPage(true);
		return res;
	}

	@Override
	public ObjectResult getNewsHtml(String pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
