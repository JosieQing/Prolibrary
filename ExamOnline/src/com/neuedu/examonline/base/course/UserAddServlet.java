package com.neuedu.examonline.base.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	
    public UserAddServlet() {
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
		String sevletId=request.getParameter("id");
		String sevletCouse=request.getParameter("couse");
		UserObj uo = new UserObj();
		uo.setId(sevletId);
		uo.setCouse(sevletCouse);	
		UserBean ub = new UserBean();
		int result = ub.addUser(uo);
	
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		
	}

}
