package com.neuedu.examonline.subjectlib.question;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionAddServlet
 */
@WebServlet("/QuestionAddServlet")
public class QuestionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionAddServlet() {
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
		// TODO Auto-generated method stub
		String questiontext = request.getParameter("questiontext");
		PrintWriter out = response.getWriter();
		String a = request.getParameter("A");
		String b = request.getParameter("B");
		String c = request.getParameter("C");
		String d = request.getParameter("D");
	    String e = request.getParameter("E");
		String c_id = request.getParameter("c_id");
		String t_id = request.getParameter("t_id");
		String remark = request.getParameter("remark");
		int servletc_id = Integer.valueOf(c_id);
		int servlett_id = Integer.valueOf(t_id);
		String user_id = request.getParameter("user_id");
		QuestionObj qo = new QuestionObj();
		qo.setA(a);
		qo.setB(b);
		qo.setC(c);
		qo.setD(d);
		qo.setE(e);
		qo.setQuestiontext(questiontext);
		qo.setC_id(servletc_id);
		qo.setTypes_id(servlett_id);
		qo.setRemark(remark);
		QuestionBean qb = new QuestionBean();
		int r = qb.addQuestion(qo, user_id);
		if(r==1){
			out.print("{\"result\":\"1\"}");
		}else{
			out.print("{\"result\":\"2\"}");
		}
	}

}
