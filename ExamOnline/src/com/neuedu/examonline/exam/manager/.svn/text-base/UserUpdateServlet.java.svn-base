package com.neuedu.examonline.exam.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	
    public UserUpdateServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sevletId=request.getParameter("id");
		String sevletExam_name=request.getParameter("exam_name");
		String sevletRemark=request.getParameter("remark");
		String sevletTest_paper_name=request.getParameter("test_paper_name");
		String sevletExam_class=request.getParameter("exam_class");
		UserObj uo = new UserObj();
		uo.setId(sevletId);
		uo.setExam_name(sevletExam_name);
		uo.setRemark(sevletRemark);
		uo.setTest_paper_name(sevletTest_paper_name);
		uo.setExam_class(sevletExam_class);
		UserBean ub = new UserBean();
		int result = ub.updateUser(uo);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		
	}

}
