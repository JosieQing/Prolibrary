package com.neuedu.examonline.report.chart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GztBean {
	public List zhuXing(List a, List laa, String ksz) {
		List b = new ArrayList();
		List c = new ArrayList();
		b.add(laa);
		Connection conn = null;
		Statement stat = null;
		Statement stat1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		int i = 0;
		try {
			conn = DB.opendb();
			stat = conn.createStatement();
			stat1 = conn.createStatement();
			Iterator it = a.listIterator();
			while(it.hasNext()) {
				String woyun = (String) it.next();
				String sql = "select * from kgcj k join exam_management e on k.ksbh=e.id join ks_zu ks on ks.kszno=e.kszno where xh="
						+ woyun
						+ " and ks.kszno="
						+ ksz
						+ " order by exam_name";
				rs = stat.executeQuery(sql);
				List d = new ArrayList();
				while(rs.next()) {
					if (i == 0) {
						String aa = rs.getString("exam_name");
						c.add(aa);
					}
					String aa1=null;
					int aa = rs.getInt("fs");
					String bb = rs.getString("ksbh");
				 String	sql1 = "select * from zgcj zg join exam_management e on zg.exam_id=e.id where stu_id="
							+ woyun + " and e.id=" + bb;
					rs1 = stat1.executeQuery(sql1);
					while (rs1.next()) {
					  
						aa = aa + rs1.getInt("score");
						
						
					}
					aa1=""+aa;
					//System.out.println(aa1);
					d.add(aa1);
				    }
				b.add(d);
				i++;
			}
			b.add(c);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				if (stat != null) {
					if (stat1 != null) {
					if (rs != null) {
						if (rs1 != null) {
							try {
								rs1.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					try {
						stat1.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
					try {
						stat.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}

	public List zheXian(String a) {

		List b = new ArrayList();
		List c = new ArrayList();
		List d = new ArrayList();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		int i = 0;
		try {
			conn = DB.opendb();
			stat = conn.createStatement();
			String sql = "select distinct exam_name from kgcj k join exam_management e on k.ksbh=e.id join ks_zu ks on ks.kszno=e.kszno where xh="
					+ a + "  order by exam_name";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				String aaa = rs.getString("exam_name");
				c.add(aaa);
			}
			sql = "select distinct e.kszno as ee from kgcj k join exam_management e on k.ksbh=e.id join ks_zu ks on ks.kszno=e.kszno where xh="
					+ a + "  order by e.kszno";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				String aaa = rs.getString("ee");
				b.add(aaa);
			}
			System.out.println(c.size());
			System.out.println(b.size());
			d.add(b);//b�ǿ���������
			d.add(c);//c�ǿ�Ŀ����
			Iterator it = c.listIterator();
			while (it.hasNext()) {
				String lalala = (String) it.next();
				Iterator it1 = b.listIterator();
				List f = new ArrayList();
				while (it1.hasNext()) {
					String lala = (String) it1.next();
					sql = "select *  from kgcj k join exam_management e on k.ksbh=e.id join ks_zu ks on ks.kszno=e.kszno where xh="
							+ a
							+ "  and e.kszno="
							+ lala
							+ " and exam_name='"
							+ lalala+"'";
					rs1 = stat.executeQuery(sql);
					if (rs1.next()) {
						String aa1=null;
						int aa = rs1.getInt("fs");
						String bb = rs1.getString("ksbh");
						sql = "select * from zgcj zg join exam_management e on zg.exam_id=e.id where stu_id="
								+ a + " and e.id=" + bb;
						rs1 = stat.executeQuery(sql);
						while (rs1.next()) {
							aa = aa + rs1.getInt("score");
						}
						aa1=""+aa;
						System.out.println(aa1);
						f.add(aa1);
					}
				}
				d.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				if (stat != null) {
					if (rs != null) {
						if (rs1 != null) {
							try {
								rs1.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					try {
						stat.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return d;

	}

	public List leiDa(String a, String b) {
		List de = new ArrayList();
		List ce = new ArrayList();
		List be = new ArrayList();
		Connection conn = null;
		Statement stat = null;
		Statement stat1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;

		try {
			conn = DB.opendb();
			stat = conn.createStatement();
			stat1 = conn.createStatement();

			String sql = "select * from kgcj k join exam_management e on k.ksbh=e.id join ks_zu ks on ks.kszno=e.kszno where xh="
					+ a + " and ks.kszno=" + b + " order by exam_name";
			rs = stat.executeQuery(sql);
			while (rs.next()) {

				String aaa = rs.getString("exam_name");
				de.add(aaa);
				int aa = rs.getInt("fs");
				String bb = rs.getString("ksbh");
				sql = "select * from zgcj zg join exam_management e on zg.exam_id=e.id where stu_id="
						+ a + " and e.id=" + bb;
				rs1 = stat1.executeQuery(sql);
				while (rs1.next()) {
					aa = aa + rs1.getInt("score");
				}
				String aa1=""+aa;
				ce.add(aa1);
			}
			be.add(de);
			be.add(ce);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				if (stat != null) {
					if (stat1 != null) {
					if (rs != null) {
						if (rs1 != null) {
							try {
								rs1.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					try {
						stat1.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
					try {
						stat.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return be;

	}
	
	public String fanHuiKsz(String a){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String b=null;
		try{
			conn = DB.opendb();
			stat = conn.createStatement();
			String sql="select * from ks_zu where miaosu='"+a+"'";
			rs=stat.executeQuery(sql);
			if(rs.next()){
				b=rs.getString("kszno");
			}
		}catch (Exception e) {
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

		return b;
	}
}
