package com.ajax.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class SearchServlet extends HttpServlet{
	static List<String> datas = new ArrayList<String>();
	static {
		
		datas.add("ajax");
		datas.add("ajax post");
		datas.add("becky");
		datas.add("bill");
		datas.add("james");
		datas.add("jerry");
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String keyword = request.getParameter("keyword");
		List<String> listdata = getData(keyword);
		response.getWriter().write(JSONArray.fromObject(listdata).toString());
	}
	 
	public List<String> getData(String keyword){
		List<String> list = new ArrayList<String>();
		for(String data:datas){
			if(data.contains(keyword)){
				list.add(data);
			}
		}
		return list;
	}
	
	
}
