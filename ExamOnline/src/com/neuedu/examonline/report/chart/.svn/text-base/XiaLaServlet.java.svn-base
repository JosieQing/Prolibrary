package com.neuedu.examonline.report.chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/XiaLaServlet")
public class XiaLaServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XiaLaServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String w = request.getParameter("w");
		List li1 = new ArrayList();
		XiaLaBean xl=new XiaLaBean();
		if("1".equals(w)){
		li1=xl.banJi();}
		if("2".equals(w)){
		li1=xl.kaoShiMing();}
		if("3".equals(w)){
		li1=xl.kaoShiZu();}
//		Gson gs=new Gson();
//		String s1=gs.toJson(li1);
//		System.out.println(s1);
		String s1="{";
		int i=1;
		for(Object temp:li1){
			String temp1=(String)temp;
			s1=s1+"\"s"+i+"\":\""+temp1+"\",";
			i++;	
		}
		s1=s1.substring(0,s1.length()-1)+"}";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(s1);
		out.close();
	}

}