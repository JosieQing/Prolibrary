package com.neusoft.control;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import com.neusoft.bean.EmpEntry;
import com.neusoft.mapping.MappingFactory;
import com.neusoft.service.EmpEntryService;
import com.neusoft.service.impl.EmpEntryServiceImpl;

import com.neusoft.util.Pagination;

public class EmpEntryServlet extends HttpServlet{
	private ServletConfig config;
	private int pageSize=0;
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String state  = request.getParameter("s");	
		if(state.equals("addEmp")){
			addEmpMessage(request,response, out);
			}
		else if(state.equals("message")){
			getEmployeeMessage(request,response);
		}
		else if(state.equals("delete")){
			deleteEmpMessage(request,response,out);
		}else if(state.equals("modify")){
			modifyEmpMessage(request,response, out);
		}
//		}else if(state.equals("check")){
//			getEmpMessageByEid(request,response, out);
//		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	/**
	 * 添加员工信息
	 */
		protected void addEmpMessage(HttpServletRequest request, HttpServletResponse response,PrintWriter out )
			throws ServletException, IOException{
			EmpEntryService es=new EmpEntryServiceImpl();
			EmpEntry ee=new EmpEntry();
			ee.setEid(Integer.valueOf(request.getParameter("eid")));
			ee.setEname(request.getParameter("ename"));
			ee.setCard(request.getParameter("card"));
			/**出生日期**/
			String birthday = request.getParameter("birthday");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date ustime1;
			try {
				ustime1 = format1.parse(birthday);
				java.sql.Date stime1 = new java.sql.Date(ustime1.getTime());
				ee.setBirthday(stime1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ee.setSex(request.getParameter("sex"));
			ee.setDeptno(Integer.valueOf(request.getParameter("deptno")));
			ee.setDname(request.getParameter("dname"));
			ee.setJobno(Integer.valueOf(request.getParameter("jobno")));
			ee.setJname(request.getParameter("jname"));
			/**工作日期**/
			String workDay = request.getParameter("workDay");
			SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date ustime2;
			try {
				ustime2 = format2.parse(workDay);
				java.sql.Date stime2 = new java.sql.Date(ustime2.getTime());
				ee.setWorkDay(stime2);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			ee.setEmpForm(request.getParameter("empForm"));
			ee.setPersonSource(request.getParameter("personSource"));
			ee.setPoliticStatus(request.getParameter("politicStatus"));
			ee.setNationalCity(request.getParameter("nationalCity"));
			ee.setNativePlace(request.getParameter("nativePlace"));
			ee.setPhone(request.getParameter("phone"));
			ee.setEmail(request.getParameter("email"));
			ee.setHeight(request.getParameter("height"));
			ee.setBloodType(request.getParameter("bloodType"));
			ee.setMarriage(request.getParameter("marriage"));
			ee.setBirthPlace(request.getParameter("birthPlace"));
			ee.setResidentPlace(request.getParameter("residentPlace"));
			ee.setHighestEducation(request.getParameter("highestEducation"));
			ee.setHighestOffering(request.getParameter("highestOffering"));
			ee.setGraduateSchool(request.getParameter("graduateSchool"));
			/**毕业日期**/
			String graduateDay = request.getParameter("graduateDay");
			SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date ustime3;
			try {
				ustime3 = format3.parse(graduateDay);
				java.sql.Date stime3 = new java.sql.Date(ustime3.getTime());
				ee.setGraduateDay(stime3);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ee.setForeignLanguage(request.getParameter("foreignLanguage"));
			ee.setCareer(request.getParameter("career"));
			ee.setFamilyRelationship(request.getParameter("familyRelationship"));
			ee.setSocialRelationship(request.getParameter("socialRelationship"));
			ee.setIdStyle(request.getParameter("idStyle"));
			/**转正日期**/
			String formalDay = request.getParameter("formalDay");
			SimpleDateFormat format4= new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date ustime4;
			try {
				ustime4 = format4.parse(formalDay);
				java.sql.Date stime4 = new java.sql.Date(ustime4.getTime());
				ee.setFormalDay(stime4);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			/**试用日期**/
			String probationDay = request.getParameter("probationDay");
			SimpleDateFormat format5= new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date ustime5;
			try {
				ustime5 = format5.parse(probationDay);
				java.sql.Date stime5= new java.sql.Date(ustime5.getTime());
				ee.setProbationDay(stime5);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			ee.setState(request.getParameter("state"));
			try {
				boolean isRight=es.addEmpMessage(ee);
				if(isRight==true){
//					getEmployeeMessage(request,response);
					String alert="<script>alert('添加成功！');</script>";
					out.println(alert);	
				}else{
					String alert="<script>alert('添加失败！');</script>";
					out.println(alert);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
		}
//		@Override
//		/**
//		 * 获取pageSize
//		 */
//		public void init(ServletConfig config) throws ServletException {
//			super.init(config);
//			//获取初始化参数pageSize（web.xml）
//			pageSize = Integer.parseInt(config.getServletContext()
//					.getInitParameter("pageSize"));
//		}
		/**
		 * 获取pageSize
		 */
		public void init(ServletConfig config)
		throws ServletException{
			this.config=config;
			//pageSize在web.xml属于context类型
			ServletContext page=config.getServletContext();
			pageSize=Integer.parseInt(page.getInitParameter("pageSize"));
			
		}
		/**
		 * 获取员工信息
		 */
		protected void getEmployeeMessage(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
			EmpEntryService es=new EmpEntryServiceImpl();
			int pageNumber=0;
			//获取参数的名称
			String paramName=new ParamEncoder("ee").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
			try {
			//获取当前页码
			String paramName1=request.getParameter(paramName);
			pageNumber=Integer.parseInt(paramName1);
			}catch(Exception e){
			//如果没有获取当前页码那么将页码设置为1
			pageNumber=1;
			} 
			String eid = request.getParameter("eid");
			String ename = request.getParameter("ename");
			String deptno = request.getParameter("deptno");
			String jobno = request.getParameter("jobno");
			
			try {
				Pagination pg=es.getEmployeeByPage(eid, ename, deptno, jobno, pageSize, pageNumber);
				MappingFactory mf=MappingFactory.getMappingFactory();
				//将某一区间段内的记录保存在request中
				request.setAttribute("list", pg.getList(mf.getMapping(MappingFactory.EmpEntry_MAPPING)));
				//将总的记录数保存到request中
				request.setAttribute("total", pg.getMaxElements());
				//转发页面
				request.getRequestDispatcher("/admin/secure/EmployeeManager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		/**
//		 * 根据ID查询员工信息(只有一条记录？)
//		 */
//		protected void getEmpMessageByEid(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
//		throws ServletException, IOException{
//			EmpEntryService es=new EmpEntryServiceImpl();
//			Integer eid = Integer.valueOf(request.getParameter("eid"));
//			EmpEntry ee=new EmpEntry();
//			try {
//				ee=es.getEmpMessageById(eid);
//				List<EmpEntry> e=new ArrayList<EmpEntry>();
//				e.add(ee);//将一个对象加到集合中
//				request.setAttribute("list",e);
//				if(ee!=null){
//					request.getRequestDispatcher("/admin/secure/EmployeeManager.jsp").forward(request, response);
//				}
//				else{
//					String alert="<script>alert('没有这个员工！');</script>";
//					out.println(alert);	
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		/**
		 * 删除员工信息
		 */
		protected void deleteEmpMessage(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
		throws ServletException, IOException{
			Integer eid=Integer.valueOf(request.getParameter("eid"));
			EmpEntryService es=new EmpEntryServiceImpl();
			boolean isRight;
			try {
				isRight =es.deleteEmpMessage(eid);
				if(isRight==true){
//					getEmployeeMessage(request,response);	
					String alert="<script>alert('删除成功！');</script>";
					out.println(alert);	
				}else{
					String alert="<script>alert('删除失败！');</script>";
					out.println(alert);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}		
		}
		/**
		 * 修改员工信息
		 */
		protected void modifyEmpMessage(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
				throws ServletException, IOException{
					EmpEntryService es=new EmpEntryServiceImpl();
					EmpEntry ee=new EmpEntry();
					ee.setEid(Integer.valueOf(request.getParameter("eid")));
					ee.setEname(request.getParameter("ename"));
					ee.setSex(request.getParameter("sex"));
					ee.setDeptno(Integer.valueOf(request.getParameter("deptno")));
					ee.setJobno(Integer.valueOf(request.getParameter("jobno")));
					/**工作日期**/
					String workDay = request.getParameter("workDay");// 得到字符串形式的時間
					SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date ustime2;
					try {
						ustime2 = format2.parse(workDay);
						java.sql.Date stime2 = new java.sql.Date(ustime2.getTime());
						ee.setWorkDay(stime2);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					ee.setPhone(request.getParameter("phone"));
					ee.setEmail(request.getParameter("email"));
					/**转正日期**/
					String formalDay = request.getParameter("formalDay");
					SimpleDateFormat format3= new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date ustime3;
					try {
						ustime3 = format3.parse(formalDay);
						java.sql.Date stime3 = new java.sql.Date(ustime3.getTime());
						ee.setFormalDay(stime3);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					/**试用日期**/
					String probationDay = request.getParameter("probationDay");
					SimpleDateFormat format5= new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date ustime5;
					try {
						ustime5 = format5.parse(probationDay);
						java.sql.Date stime5= new java.sql.Date(ustime5.getTime());
						ee.setProbationDay(stime5);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					boolean isRight=false;
					try {
						isRight=es.modifyEmpMessage(ee);
						if(isRight==true){	
							String alert="<script>alert('修改成功！');</script>";
							out.println(alert);						
							getEmployeeMessage(request,response);		
						}else{
							String alert2="<script>alert('修改失败！');</script>";
							out.println(alert2);						
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{
						out.flush();
						out.close();
					}
				}
}
