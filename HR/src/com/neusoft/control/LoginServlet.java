package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.bean.Admin;
import com.neusoft.service.AdminService;
import com.neusoft.service.impl.AdminServiceImpl;

public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 向客户端返回的内容类型html,utf_8
		response.setContentType("text/html;charset=utf-8");
		// 获取一个打印流PrintWriter对象
		PrintWriter out = response.getWriter();
		// 设置客户端请求的编码格式为utf-8
		request.setCharacterEncoding("utf-8");
		
		
		String statu = request.getParameter("q");
		if(statu.equals("login")){
			
			doLogin(request, response, out)	;	
		}else {
			outLogin(request,response,out);
		}
	}
	
	// 登录
	protected void doLogin(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminService Adminervice = new AdminServiceImpl();
		Admin admin = Adminervice.isValidate(username, password);
		try {
			if(admin!=null){
				
				// 跳转到所有信息的界面
				HttpSession session = request.getSession();
				session.setAttribute("username",admin.getUsername());
				request.getRequestDispatcher("/servlet/adminManagerServlet?q=list").forward(request, response);
				
				}else{
					//用户名或密码错误 
					request.setAttribute("err","用户名或密码错误！");
					request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
					
				}
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				out.flush();
				out.close();
			}
		}
	
	
	
	// 退出登录
	protected void outLogin(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		
		
		}

	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	
}
