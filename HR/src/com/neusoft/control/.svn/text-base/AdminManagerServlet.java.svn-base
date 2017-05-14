package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import com.neusoft.bean.Admin;
import com.neusoft.mapping.MappingFactory;
import com.neusoft.service.AdminService;
import com.neusoft.service.impl.AdminServiceImpl;
import com.neusoft.util.Pagination;

public class AdminManagerServlet extends HttpServlet{

	private static final long serialVersionUID = 9L;
	private int pageSize = 0;
	private ServletConfig config;
	
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
		if(statu.substring(0,6).equals("modify")){
			
			doUpDate(request, response, out);
		}
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		ServletContext servletContext = config.getServletContext();
		pageSize = Integer.parseInt(servletContext.getInitParameter("pageSize"));
		
	}
	
	/**
	 * 修改用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doUpDate(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("q").substring(6));

		
		String username = request.getParameter("DivUsername");
		String password = request.getParameter("DivPwd");
		Admin admin = new Admin(username,password);
		admin.setId(id);
		
		AdminService userService = new AdminServiceImpl();
		
		try {
			if(userService.upDate(admin,id)){
				response.sendRedirect("/HR/admin/secure/FirstPage.jsp");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
