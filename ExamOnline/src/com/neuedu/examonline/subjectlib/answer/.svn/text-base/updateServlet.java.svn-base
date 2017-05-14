package com.neuedu.examonline.subjectlib.answer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.examonline.subjectlib.answer.answerBean;
import com.neuedu.examonline.subjectlib.answer.answerObj;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletKg_id=request.getParameter("kg_id");
		String servletKg_answer=request.getParameter("kg_answer");
		String servletCurp=request.getParameter("curp");

		
		answerObj ao=new answerObj();
		ao.setKg_id(servletKg_id);
		ao.setKg_answer(servletKg_answer);
		
		answerBean ab=new answerBean();
		ab.updateKgAnswer(ao);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("kg_id",servletKg_id );
		
		session.setAttribute("kg_answer",servletKg_answer );
		
		response.sendRedirect("answerListKg.jsp?curp="+servletCurp);
		
		
		
	}

}
