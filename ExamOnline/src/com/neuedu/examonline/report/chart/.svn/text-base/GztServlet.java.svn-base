package com.neuedu.examonline.report.chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet("/GztServlet")
public class GztServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GztServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// response.setContentType("text/html;charset=UTF-8");
		// PrintWriter out = response.getWriter();
		// out.print("{\"result\":\"0\"}");
		// List li = new ArrayList();
		// li.add("1");
		// li.add("1");
		// HttpSession session=request.getSession();
		// session.setAttribute("Li",li);
		// out.print(li.size());
		// out.close();
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String yunyun=request.getParameter("xx");
		 HttpSession session=request.getSession();
		 GztBean gzz=new GztBean();
		 if("1".equals(yunyun)){
		 List li = new ArrayList();
		 li=(List) session.getAttribute("LL");
		List lli=(List) session.getAttribute("LL1");
		 String yun1=request.getParameter("ksz");
		 String yun2=gzz.fanHuiKsz(yun1);
		 List li1 = gzz.zhuXing(li,lli, yun2);
		 session.setAttribute("lii1", li1);
	
			 PrintWriter out = response.getWriter();
//			 Iterator it = li1.listIterator();
//			 while(it.hasNext())
//			 { List liii=(List)it.next();
//				 Iterator it1 = liii.listIterator();
//				 while(it1.hasNext()){
//					 String x5=(String)it1.next();
//					 out.print(x5);
//				 }
//			 }
			 out.print("{\"result\":\"0\"}");
			 out.close();
		 }
		 if("2".equals(yunyun)){
		 String yun2=request.getParameter("id");
		 List li2 = gzz.zheXian(yun2);
		 session.setAttribute("lii2", li2);
		 PrintWriter out = response.getWriter();
//		 Iterator it = li2.listIterator();
//		 while(it.hasNext())
//		 { List liii=(List)it.next();
//			 Iterator it1 = liii.listIterator();
//			 while(it1.hasNext()){
//				 String x5=(String)it1.next();
//				 out.print(x5);
//			 }
//		 }
		 out.print("{\"result\":\"0\"}");
		 out.close();
		 }
		 if("3".equals(yunyun)){
		 String yun3=request.getParameter("id");
		 String yun4=request.getParameter("ksz");
		 String yun5=gzz.fanHuiKsz(yun4);
		 List li3=gzz.leiDa(yun3, yun5);
		 session.setAttribute("lii3",li3);
		 
		 PrintWriter out = response.getWriter();
		 Iterator it = li3.listIterator();
//		 while(it.hasNext())
//		 { List liii=(List)it.next();
//			 Iterator it1 = liii.listIterator();
//			 while(it1.hasNext()){
//				 String x5=(String)it1.next();
//				 out.print(x5);
//			 }
//		 }
		 out.print("{\"result\":\"0\"}");
		 out.close();
		 }
//		String ii = request.getParameter("id");
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print("{\"result\":\""+ii+"\"}");
//		out.close();
	}
}