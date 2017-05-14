package com.neuedu.examonline.subjectlib.question;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionDeleteServlet
 */
@WebServlet("/QuestionDeleteServlet")
public class QuestionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q_id = request.getParameter("q_id");
		QuestionBean qb = new QuestionBean();
		PrintWriter out = response.getWriter();
		int r = qb.deleteQuestion(q_id);
		if(r==1){
			out.print("{\"result\":\"1\"}");
		}else{
			out.print("{\"result\":\"2\"}");
		}
		
		
		
		
		
	}

}
