package com.neuedu.examonline.report.chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print("{\"result\":\"0\"}");
//		List li = new ArrayList();
//		li.add("1");
//		li.add("1");
//		HttpSession session=request.getSession();
//		session.setAttribute("Li",li);
//		out.print(li.size());
//		out.close();
		doPost(request,response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String xa = request.getParameter("xa");
		StudentBean st = new StudentBean();
		List<String> li = new ArrayList<String>();
		HttpSession session=request.getSession();
		if ("1".equals(xa)) {
			String a = request.getParameter("a");
			li = st.muHu(a);
			
		}
		if ("2".equals(xa)) {
			String a = request.getParameter("a");
			String b = request.getParameter("b");
			String c = request.getParameter("c");
			String d = request.getParameter("d");
			String e = request.getParameter("e");
             li=st.gMuHu(a, b, c, d, e);
            
		}
		if ("3".equals(xa)) {
          String a=request.getParameter("a");
          li=st.kaoShiMing(a);
         
		}
		if ("4".equals(xa)) {
		   String a=request.getParameter("a");
		   System.out.print(a);
		   li=st.kaoShiZu(a);
		  
		}
		 session.setAttribute("Li",li);
		 response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(li.size());
			out.close();
		 
	}

}