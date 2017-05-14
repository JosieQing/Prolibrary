<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.neuedu.examonline.util.*"%>	
<%@page import="com.neuedu.examonline.stufunc.anssheet.*"%>
<%@ include file="../../inc/db.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int stu_id = 0;
		//stu_id =(Integer)session.getAttribute("stu_id");

		String examNum = null;
		examNum = request.getParameter("shijuanid");//
		if (examNum == null) {
			examNum = "";
		}
		String[] shitiid = null;
		shitiid = request.getParameterValues("shitiid");
		Statement stat = null;
		ResultSet rs = null;

		try {
			

			for (int i = 0; i < shitiid.length; i++) {
				String daan="X";
				String jd = null;
				String type = null;
				type = request.getParameter("typeid"+shitiid[i]);
				
				
				if(type.equals("2")){
					jd = request.getParameter("jdQuizradio"+shitiid[i]);
					daan=jd;
					daan=StringUtil.iSOToUtf8(daan);
				}else{
					String[] xz = null;
					xz = request.getParameterValues("Quizradio"+shitiid[i]);
					if(xz!=null){
					for(int j=0;j<shitiid.length; j++){
						if(xz[j]!=null){
							daan=xz[j];
							break;
						}
					}
					}
				}
				String sql = "insert into exam_result(id,stu_id,examNum,questions_id,examAnswer) values(EXAM_RESULT_SEQ.nextval,'"
						+ stu_id + "','" + examNum + "','"+shitiid[i]+"','"+daan+"')";
				System.out.println("sql--:" + sql);
				stat=conn.createStatement();
				stat.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}

		}

		
		
		//得到题号数组并循环

		/*{
			//判断选择简答

			//if 选择  取选择选项不为空的值

			//if 简答  直接取String areaList=null; tttt=request.getParameter("textarea");

			//根据session学号，考试编号，数组题号，判断后的值insert into

		}
		//if xz
		String questions_id = request.getParameter("Quizradio" + tihao[i]);//
		if (questions_id == null) {
			questions_id = "";
		}
		String[] QuizList = null;
		QuizList = request.getParameterValues("Quizradio");

		//jd
		String areaList = null;
		tttt = request.getParameter("textarea");*/
 response.sendRedirect("exam_menu.jsp");%>
</body>
</html>