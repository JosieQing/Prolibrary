package com.neuedu.examonline.report.predict;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;


@WebServlet("/classcheck")
public class classcheck extends HttpServlet {
	
    public classcheck() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classname=request.getParameter("classname");
		check cc = new check();
		double[] a=cc.checkbyclass(classname);
		String s="";
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
			s=s+a[i]+",";
		}
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Gson g=new Gson();
		out.print(s);
		out.close();
		}
}

