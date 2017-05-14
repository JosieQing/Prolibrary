package com.neuedu.examonline.subjectlib.type;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/ProblemTypesServlet")
public class ProblemTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProblemTypesDAO typesDao=new ProblemTypesDAO();
	Gson gson=new Gson();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String func=request.getParameter("func");
		if(func.equals("add")){
			addTypes(request,response);
		}
		if(func.equals("findTypes")){
			findTypes(request,response);
		}
		if(func.equals("delete")){
			deleteTypes(request,response);
		}
	
	}
	
	protected void addTypes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String types_addName=request.getParameter("types_addName");
		PrintWriter out=response.getWriter();
		try {
			boolean flag=typesDao.addTypes(types_addName);
			if(flag==true){
				out.print("{\"result\":\"1\"}");
				out.close();
			}else{
				out.print("{\"result\":\"0\"}");
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void findTypes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String types_updateId=request.getParameter("types_updateId");
		try {
			ProblemTypesBean bean=typesDao.getTypesById(types_updateId);
			String ProblemTypes= gson.toJson(bean);
			PrintWriter out=response.getWriter();
			out.print(ProblemTypes);
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void deleteTypes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delete_id=request.getParameter("delete_id");
		try {
			int i=typesDao.deleteProblemTypes(delete_id);
			PrintWriter out=response.getWriter();
			out.print(i);
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
