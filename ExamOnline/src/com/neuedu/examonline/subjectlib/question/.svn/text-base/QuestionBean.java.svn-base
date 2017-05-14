package com.neuedu.examonline.subjectlib.question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.examonline.db.BaseBean;
import com.neuedu.examonline.db.ConnC3p0DS;

public class QuestionBean extends BaseBean{

	public List<CourseObj> getAllCourse() {
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		List<CourseObj> li = new ArrayList<CourseObj>();
		try {
			String sql = "select * from course ";
			System.out.println(sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				String couse = rs.getString("couse");
				int id = rs.getInt("id");
				CourseObj co = new CourseObj();
				co.setCouse(couse);
				co.setId(id);
				li.add(co);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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

		return li;

	}

	public List<TypesObj> getAllType() {
	    Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		List<TypesObj> li = new ArrayList<TypesObj>();
		try {
			String sql = "select * from PROBLEM_TYPES ";
			System.out.println(sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				TypesObj to = new TypesObj();
				int types_id = rs.getInt("types_id");
				String types_name = rs.getString("types_name");
				to.setTypes_id(types_id);
				to.setTypes_name(types_name);
				li.add(to);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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

		return li;

	}

	public List<QuestionObj> getList(String course_id, String types_id,
			int rowIndex, int PageSize) {
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		List<QuestionObj> questionList = new ArrayList<QuestionObj>();
		try {
			int i = 1;
			String sql = "select * from question where 1=1";
			if (!types_id.equals("") && !(types_id.equals("不选"))) {
				sql = sql + " and type_id =" + types_id + " ";
			}
			if (!course_id.equals("") && !(course_id.equals("不选"))) {

				sql = sql + " and cid =" + course_id + " ";
			}
			stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stat.executeQuery(sql);
			System.out.println(sql);
			if (rowIndex != 0) {
				rs.absolute(rowIndex);
			}
			while (rs.next()) {
				i++;

				QuestionObj qo = new QuestionObj();
				int id = rs.getInt("id");
				String questiontext = rs.getString("questiontext");
				String a = rs.getString("A");
				String b = rs.getString("B");
				String c = rs.getString("C");
				String d = rs.getString("D");
				String e = rs.getString("E");
				qo.setA(a);
				qo.setB(b);
				qo.setC(c);
				qo.setD(d);
				qo.setE(e);
				qo.setId(id);
				qo.setQuestiontext(questiontext);
				questionList.add(qo);
				if (i > PageSize) {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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

		return questionList;

	}

	public int getCount(String types_id, String course_id) {
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		int rowTotal = 0;
		try {
			String sql = "select count(*) as rowTotal from question where 1=1";
			if (!types_id.equals("") && !(types_id.equals("不选"))) {
				sql = sql + " and type_id =" + types_id + " ";
			}
			if (!course_id.equals("") && !(course_id.equals("不选"))) {

				sql = sql + " and cid =" + course_id + " ";
			}
			System.out.println("sql--:" + sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				rowTotal = rs.getInt("rowTotal");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return rowTotal;

	}

	public int addQuestion(QuestionObj qo, String user_id) {
		Connection conn = this.conn();
		Statement stat = null;
		int r = 0;
		try {
			String sql = "insert into QUESTION (id,questiontext,a,b,c,d,e,boss,establish,change,remark,type_id,cid)"
					+ "values (question_seq.nextval,'"
					+ qo.getQuestiontext()
					+ "','"
					+ qo.getA()
					+ "','"
					+ qo.getB()
					+ "','"
					+ qo.getC()
					+ "','"
					+ qo.getD()
					+ "','"
					+ qo.getE()
					+ "','"
					+ user_id
					+ "',sysdate,sysdate,'"
					+ qo.getRemark()
					+ "',"
					+ qo.getTypes_id() + "," + qo.getC_id() + ")";
			System.out.println("sql--:" + sql);
			stat = conn.createStatement();
			r = stat.executeUpdate(sql);
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
		return r;

	}

	public QuestionObj getQuestion(String q_id) {
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		QuestionObj qo = new QuestionObj();
		try {
			String sql = "select *  from question where id = " + q_id;
			System.out.println("sql--:" + sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {

				String questiontext = rs.getString("questiontext");
				String a = rs.getString("A");
				String b = rs.getString("B");
				String c = rs.getString("C");
				String d = rs.getString("D");
				String e = rs.getString("E");
				String remark = rs.getString("remark");
				int id = rs.getInt("id");
				qo.setA(a);
				qo.setB(b);
				qo.setC(c);
				qo.setD(d);
				qo.setE(e);
				qo.setQuestiontext(questiontext);
				qo.setRemark(remark);
				qo.setId(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return qo;

	}

	public int UpdateQuestion(QuestionObj qo, String user_id) {
		Connection conn = this.conn();
		Statement stat = null;
		int r = 0;
		try {
			String sql = "Update QUESTION set questiontext = '"
					+ qo.getQuestiontext() + "',A='" + qo.getA() + "',B='"
					+ qo.getB() + "',C='" + qo.getC() + "',D='" + qo.getD()
					+ "',E='" + qo.getE() + "',type_id='" + qo.getTypes_id()
					+ "',remark='" + qo.getRemark() + "',boss='" + user_id
					+ "',establish=sysdate,change=sysdate where id = "
					+ qo.getId();

			System.out.println("sql--:" + sql);
			stat = conn.createStatement();
			r = stat.executeUpdate(sql);
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
		return r;

	}

	public int deleteQuestion(String q_id) {
		Connection conn = this.conn();
		Statement stat = null;
		int r = 0;
		try {
			String sql = "delete question where id=" + q_id;

			System.out.println("sql--:" + sql);
			stat = conn.createStatement();
			r = stat.executeUpdate(sql);
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
		return r;

	}

}
