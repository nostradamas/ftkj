package com.qd.ftkj.website.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.qd.ftkj.website.service.WebsiteService;
import com.qd.ftkj.website.utils.ParamUtil;

@Controller
@RequestMapping("/website")
public class WebsiteController extends BaseController {
	@Resource
	private WebsiteService webServiceImpl;
	
	public void setWebServiceImpl(WebsiteService webServiceImpl) {
		this.webServiceImpl = webServiceImpl;
	}
	
	/**
	 * 跳转首页
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "index";
	}
	
	/**
	 * 获取新闻列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getInfoList")
	@ResponseBody
	public void getInfoList(HttpServletRequest request, HttpServletResponse response) {
		Gson g = new Gson();
		try{
			
			String lminfo = ParamUtil.toStringToUtf8(request.getParameter("lminfo"), null);
			int page = ParamUtil.toInt(request.getParameter("page"), 0);
			int limit = ParamUtil.toInt(request.getParameter("limit"), 25);
			int ispic = ParamUtil.toInt(request.getParameter("ispic"), 0);
			response.setContentType("text/html;charset=UTF-8");
	        PrintWriter pw = response.getWriter();
	        pw.write(g.toJson(webServiceImpl.getInfoList(lminfo, page, limit, ispic)));
	        pw.flush();
	        pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
	}
	
	

}
