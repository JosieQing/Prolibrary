package com.neuedu.examonline.base.student;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/ListAddServlet")
public class ListAddServlet extends HttpServlet {
    public ListAddServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String sevletName=request.getParameter("name");
		String sevletNum=request.getParameter("num");
		String sevletSex=request.getParameter("sex");
		String sevleAge=request.getParameter("age");
		String sevletCname=request.getParameter("cname");
		ListObj uo = new ListObj();
		uo.setName(sevletName);
		uo.setNum(sevletNum);	
		uo.setSex(sevletSex);	
		uo.setAge(sevleAge);	
		uo.setCname(sevletCname);	
		ListBean ub = new ListBean();
		int result = ub.addList(uo);
	
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		
	}

}