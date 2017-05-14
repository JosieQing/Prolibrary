package com.neuedu.examonline.subjectlib.question;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class QuestionFindServlet
 */
@WebServlet("/QuestionFindServlet")
public class QuestionFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionFindServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		String q_id = request.getParameter("q_id");
		QuestionBean qb = new QuestionBean();
		QuestionObj qo = new QuestionObj();
		qo = qb.getQuestion(q_id);
		Gson gson = new Gson();
		String s = gson.toJson(qo);
		PrintWriter out = response.getWriter();
		out.print(s);
		System.out.println(s);
	}

}
