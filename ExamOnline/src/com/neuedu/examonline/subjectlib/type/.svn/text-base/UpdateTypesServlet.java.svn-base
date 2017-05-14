package com.neuedu.examonline.subjectlib.type;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTypesServlet")
public class UpdateTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProblemTypesDAO typesDao=new ProblemTypesDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String types_updateId=request.getParameter("types_updateId");
		String types_updateName=request.getParameter("types_updateName");
	
		ProblemTypesBean bean=new ProblemTypesBean();
		bean.setTypes_id(types_updateId);
		bean.setTypes_name(types_updateName);
		int result=0;
		try {
			result = typesDao.updateProblemTypes(bean);
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
