package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import com.neusoft.bean.EmpEntry;
import com.neusoft.bean.ProbationMan;
import com.neusoft.mapping.MappingFactory;
import com.neusoft.service.EmpEntryService;
import com.neusoft.service.ProbationManService;
import com.neusoft.service.impl.EmpEntryServiceImpl;
import com.neusoft.service.impl.ProbationManServiceImpl;
import com.neusoft.util.Pagination;

public class ProbationManServlet extends HttpServlet {

	private static final long serialVersionUID = 4L;
	private int pageSize = 0;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");

		String statu = request.getParameter("s");
		if (statu.equals("add")) {

			addProbationInfo(request, response, out);
		} else if (statu.equals("man")) {

			probationManInfo(request, response, out);
		} else if (statu.equals("eidandstate")) {

			getProbationManByPage(request, response, out);
		} else if (statu.equals("emp")) {

			docheck(request, response, out);
		}
		
	}

	public void docheck(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {

		Integer eid = Integer.valueOf(request.getParameter("eid"));
		EmpEntryService ees = new EmpEntryServiceImpl();
		try {
			if (ees.getEmpMessageById(eid) != null) {
				out.print("1");
			} else {
				out.print("0");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	

	/**
	 * 试用期信息简单录入
	 * 
	 * @param request
	 * @param response
	 * @param out
	 */
	public void addProbationInfo(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {

		try {
			// 获取jsp中的表单数据
			Integer eid = Integer.valueOf(request.getParameter("eid1"));

			// 将字符串型转为DATE型
			String probationDay = request.getParameter("probationDay");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date uprobationDay = format.parse(probationDay);
			java.sql.Date sprobationDay = new java.sql.Date(uprobationDay
					.getTime());
			Integer probationTime = Integer.valueOf(request
					.getParameter("probationTime"));

			// 实例化对象并初始化，调用"简单试用信息信息录入"方法
			ProbationMan pm = new ProbationMan();
			EmpEntryService ees = new EmpEntryServiceImpl();
			ProbationManService pms = new ProbationManServiceImpl();

			// 判断输入的eid是否存在
			if (ees.getEmpMessageById(eid) != null) {
				// 员工不存在试用期
				if ("临时员工".equals(ees.getEmpForm(eid))) {

					// 判断输入的pmid是否已经录入过基本信息
					if (pms.getProbationInfoByEid(eid) == null) {

						pm.setEid(eid);
						pm.setProbationDay(sprobationDay);
						pm.setProbationTime(probationTime);
						if (pms.addProbationInfo(pm)) {

							request.setAttribute("q", "录入成功！");
							request.getRequestDispatcher(
									"/admin/secure/probationMan.jsp").forward(
									request, response);
						}
					} else {
						// 已录入基本信息
						request.setAttribute("q", "无试用期或已经录入基本信息！");
						request.getRequestDispatcher(
								"/admin/secure/probationMan.jsp").forward(
								request, response);
					}
				} else {
					request.setAttribute("q", "员工不存在试用期！");
					request.getRequestDispatcher(
							"/admin/secure/probationMan.jsp").forward(request,
							response);
				}
			} else {
				// 员工不存在
				request.setAttribute("q", "员工不存在！");
				request.getRequestDispatcher("/admin/secure/probationMan.jsp")
						.forward(request, response);
			}
		} catch (ParseException e) {
			e.printStackTrace();
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
	 * 试用期信息管理
	 * 
	 * @param request
	 * @param response
	 * @param out
	 */
	public void probationManInfo(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {

		try {
			// 获取jsp中的表单数据
			Integer eid = Integer.valueOf(request.getParameter("eid2"));

			String result = request.getParameter("result");
			if (result.equals("1")) {
				result = "转正";
			} else if (result.equals("2")) {
				result = "延期一个月";
			} else if (result.equals("3")) {
				result = "不予录用";
			}

			String remarks = request.getParameter("remarks");

			// 实例化对象并初始化，调用"简单试用信息信息录入"方法
			ProbationMan pm = new ProbationMan();
			EmpEntryService ees = new EmpEntryServiceImpl();
			ProbationManService pms = new ProbationManServiceImpl();
			// 员工是否存在
			if (ees.getEmpMessageById(eid) != null) {
				// 判断输入的eid是否存在
				if (pms.getProbationInfoByEid(eid) != null) {

					if (pms.getProbationInfoByEid(eid).getState().equals("试用中")
							|| pms.getProbationInfoByEid(eid).getState()
									.equals("延期中")) {

						pm.setResult(result);
						pm.setRemarks(remarks);

						if (pms.probationManInfo(pm, eid)) {

							request.setAttribute("q", "信息修改成功！");
							request.getRequestDispatcher(
									"/admin/secure/probationMan.jsp").forward(
									request, response);
						} else {
							request.setAttribute("q", "信息修改失败！");
							request.getRequestDispatcher(
									"/admin/secure/probationMan.jsp").forward(
									request, response);
						}
					} else if (pms.getProbationInfoByEid(eid).getState()
							.equals("已转正")) {
						// 已转正
						request.setAttribute("q", "员工已转正！");
						request.getRequestDispatcher(
								"/admin/secure/probationMan.jsp").forward(
								request, response);
					} else if (pms.getProbationInfoByEid(eid).getState()
							.equals("未录用")) {
						// 未录用
						request.setAttribute("q", "试用期未通过，已离职！");
						request.getRequestDispatcher(
								"/admin/secure/probationMan.jsp").forward(
								request, response);
					}
				} else {
					// 员工无试用期
					request.setAttribute("q", "员工无试用期！");
					request.getRequestDispatcher(
							"/admin/secure/probationMan.jsp").forward(request,
							response);
				}
			} else {
				// 员工不存在
				request.setAttribute("q", "员工不存在！");
				request.getRequestDispatcher("/admin/secure/probationMan.jsp")
						.forward(request, response);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 查询
	 * 
	 * @param request
	 * @param response
	 * @param out
	 */
	public void getProbationManByPage(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {

		String eid = request.getParameter("eid3");
		String state1 = request.getParameter("state");

		String state = state1;
		if (state1.equals("2")) {
			state = "已转正";
		} else if (state1.equals("3")) {
			state = "延期中";
		} else if (state1.equals("4")) {
			state = "未录用";
		}

		ProbationManService pms = new ProbationManServiceImpl();
		int pageNumber = 0;
		String paramName = new ParamEncoder("probationInfo")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE);

		try {
			// 获取当前页码
			String pageNumber1 = request.getParameter(paramName);
			pageNumber = Integer.parseInt(pageNumber1);
		} catch (Exception e) {
			// 如果获取不到，默认为首页
			pageNumber = 1;
		}

		Pagination p = pms.getProbationManByPage(eid, state, pageSize,
				pageNumber);
		MappingFactory mf = MappingFactory.getMappingFactory();

		request.setAttribute("list", p.getList(mf
				.getMapping(MappingFactory.PROBATIONMAN_MAPPING)));
		request.setAttribute("total", p.getMaxElements());
		try {
			request.getRequestDispatcher("/admin/secure/probationManSel.jsp")
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

		doPost(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		pageSize = Integer
				.parseInt(servletContext.getInitParameter("pageSize"));

	}
}
