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

import com.neusoft.bean.EmpEntry;
import com.neusoft.bean.TransferMan;
import com.neusoft.mapping.MappingFactory;
import com.neusoft.service.AjaxService;
import com.neusoft.service.EmpEntryService;
import com.neusoft.service.TransferManService;
import com.neusoft.service.impl.AjaxServiceImpl;
import com.neusoft.service.impl.EmpEntryServiceImpl;
import com.neusoft.service.impl.TransferManServiceImpl;
import com.neusoft.util.Pagination;

public class TransferManServlet extends HttpServlet {

	private static final long serialVersionUID = 3L;

	private int pageSize = 0;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");

		String statu = request.getParameter("s");
		if ("add".equals(statu)) {

			addTransferInfo(request, response, out);
		} else if ("sele".equals(statu)) {

			seleProbationManInfo(request, response, out);
		}
	}

	/**
	 * 增加调动信息
	 * 
	 * @param request
	 * @param response
	 * @param out
	 */
	public void addTransferInfo(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {

		try {
			
			Integer eid = Integer.valueOf(request.getParameter("eid1"));
			String newdeptno = request.getParameter("dname2");
			String tmType = request.getParameter("tmtype");
			String newjobno = request.getParameter("jname2");
			String reason = request.getParameter("reason");
			
			if (tmType.equals("1")) {
				tmType = "主动调动";
			} else if (tmType.equals("2")) {
				tmType = "被动调动";
			} else if (tmType.equals("3")) {
				tmType = "数据录入错误";
			}
			AjaxService as = new AjaxServiceImpl();
			TransferMan tm = new TransferMan();
			EmpEntryService ees = new EmpEntryServiceImpl();
			EmpEntry ee = ees.getEmpMessageById(Integer.valueOf(eid));
			TransferManService tms = new TransferManServiceImpl();

			if (ees.getEmpMessageById(eid) != null) {

				tm.setEid(eid);
				tm.setNewDname(as.getDnameByDeptno(newdeptno));
				tm.setNewJname(as.getJobNameByJobno(Integer.parseInt(newjobno)));
				tm.setTmType(tmType);
				tm.setReason(reason);
				tm.setOldDname(ee.getDname());
				tm.setOldJname(ee.getJname());

				if (tms.addTransferInfo(tm)) {
					// 添加成功
					request.setAttribute("q", "添加成功！");
					request.getRequestDispatcher(
							"/admin/secure/transferMan.jsp").forward(request,
							response);
				}else{
					request.setAttribute("q", "添加失败！");
					request.getRequestDispatcher(
							"/admin/secure/transferMan.jsp").forward(request,
							response);
				}
			} else {

				// 员工不存在
				request.setAttribute("q", "用户名不存在！");
				request.getRequestDispatcher("/admin/secure/transferMan.jsp")
						.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询调动信息
	 * 
	 * @param request
	 * @param response
	 * @param out
	 */
	public void seleProbationManInfo(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {

		try {
			String eid = request.getParameter("eid2");
			String tmType1 = request.getParameter("tmtype2");
			String tmType = tmType1;
			if (tmType1.equals("2")) {
				tmType = "主动调动";
			} else if (tmType1.equals("3")) {
				tmType = "被动调动";
			} 
			String startday = request.getParameter("startday");
			String endday = request.getParameter("endday");

			TransferManService tms = new TransferManServiceImpl();

			int pageNumber = 0;
			String paramName = new ParamEncoder("transferInfo")
					.encodeParameterName(TableTagParameters.PARAMETER_PAGE);
			try {
				// 获取当前页码
				String pageNumber1 = request.getParameter(paramName);
				pageNumber = Integer.parseInt(pageNumber1);
			} catch (Exception e) {
				// 如果获取不到，默认为首页
				pageNumber = 1;
			}
			Pagination p = tms.getTransferInfoByPage(eid, tmType, startday,
					endday, pageSize, pageNumber);
			MappingFactory mf = MappingFactory.getMappingFactory();

			request.setAttribute("list", p.getList(mf
					.getMapping(MappingFactory.TRANSFERMAN_MAPPING)));
			// 将总的记录数保存在request中
			request.setAttribute("total", p.getMaxElements());
			// 转发页面
			request.getRequestDispatcher("/admin/secure/transferManSel.jsp")
					.forward(request, response);

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		pageSize = Integer
				.parseInt(servletContext.getInitParameter("pageSize"));

	}

}
