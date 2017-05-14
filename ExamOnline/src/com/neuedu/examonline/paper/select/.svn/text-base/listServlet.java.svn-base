package com.neuedu.examonline.paper.select;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class listServlet
 */
@WebServlet("/listServlet")
public class listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listServlet() {
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
		String questext=request.getParameter("questext");		
		PrintWriter out = response.getWriter();	
		out.print("{\"questext\":\""+questext+"\"}");
		HttpSession session=request.getSession();
		//将选择的题存入session
		String old_questext="";
		try {
			old_questext=(String)session.getAttribute("Iwant");
		} catch (Exception e) {
			// TODO: handle exception
			old_questext="";
		}		
		questext=old_questext+questext;
		String biaozhi=questext.substring(0, 1);
		if("n".equals(biaozhi))
		{
			questext=questext.substring(4);//去null字符
		}		
		System.out.println(questext);		
		session.setAttribute("Iwant", questext);
		//执行浏览功能
		
		
		
		

		
		
		
		
		
		
		
		
	}

}
