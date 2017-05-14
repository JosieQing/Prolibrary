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
import com.neuedu.examonline.util.StringUtil;

/**
 * Servlet implementation class updateZgServlet
 */
@WebServlet("/updateZgServlet")
public class updateZgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateZgServlet() {
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
		String servletZg_id=request.getParameter("zg_id");
		String servletZg_answer=request.getParameter("zg_an:wer");
		String servletCurp=request.getParameter("curp");
		
		String zg_answer=StringUtil.iSOToUtf8(servletZg_answer);
		
		answerObj ao=new answerObj();
		ao.setZg_id(servletZg_id);
		ao.setZg_answer(zg_answer);
		
		answerBean ab=new answerBean();
		ab.updateZgAnswer(ao);
		
		HttpSession session = request.getSession();
		session.setAttribute("zg_id",servletZg_id );
		session.setAttribute("zg_answer",servletZg_answer );
		response.sendRedirect("answerListZg.jsp?curp="+servletCurp);
	}

}
