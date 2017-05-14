package com.neuedu.examonline.paper.select;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class buildServlet
 */
@WebServlet("/buildServlet")
public class buildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buildServlet() {
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
		Tool to=new Tool();
		HttpSession session=request.getSession();
		//当前卷纸号
		String paperselect=(String)session.getAttribute("paperselect");
		//当前序号
		int i=1;
		String str_i=request.getParameter("i");
		System.out.print(str_i+"接收");
		if(str_i==null)
		{
			str_i="1";
		}
		System.out.print(str_i+"过if");
		
		i=Integer.parseInt(str_i);
		System.out.print(i+"转型");
		
		//题的总数
		String count=request.getParameter("count");
		int tcount=Integer.parseInt(count);
		//当前题号
		String stid=null;
		stid=request.getParameter("stid");
		//分数
		String fen=null;
		fen=request.getParameter("fen");
		
		to.update(paperselect, fen, stid);
		int temp=i+1;
		System.out.print(temp+"加一");
		
		session.setAttribute("i", temp+"");//java.lang.ClassCastException所以temp+""
		if(temp==tcount+1)
		{
			response.sendRedirect("list.jsp");
		}else
		{	
			response.sendRedirect("newbuild.jsp?i=0");//此处纯是避免newbuild的request i报错赋的值
		}
	}

}
