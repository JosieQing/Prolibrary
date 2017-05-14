package com.neuedu.examonline.paper.random.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.neuedu.examonline.paper.random.javabean.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chuanServlet")
public class chuanServlet extends HttpServlet {

	public chuanServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int it = 0;
		boolean qwe = true;
		boolean qwe1 = true;
		boolean qwe2 = true;
		boolean qwe3 = true;
		suijibean sj = new suijibean();
		
		 
		
		String shijuanming = null;
		shijuanming = request.getParameter("shijuanming");
		
		
		String xueke1 = null;
		xueke1 = request.getParameter("xueke");
		String[] xueke = xueke1.split("-");
		
		
		String tixing1 = null;
		tixing1 = request.getParameter("tixing");
		String[] tixing = tixing1.split("-");
		
		
		String tishu1 = null;
		tishu1 = request.getParameter("tishu");
		String[] tishu2 = tishu1.split("-");
		
		
		String fenshu1 = null;
		fenshu1 = request.getParameter("fenshu");
		String[] fenshu2 = fenshu1.split("-");
		
		
		if (shijuanming == "") {
			out.print("{\"result\":\"1\"}");
			out.close();
		} else {
			if (xueke1 == null||tixing1 == null||tishu1 == null||fenshu1 == null) {
			out.print("{\"result\":\"6\"}");
			out.close();
		} else {
			
			for (int i = 0; i < xueke.length; i++) {
				if (tishu2[i] == "") {
					tishu2[i] = "0";
				}
				if (!sj.panduanzifu(tishu2[i])) {
					qwe = false;
					break;
				}
			}
			for (int i = 0; i < xueke.length; i++) {
				if (fenshu2[i] == "") {
					fenshu2[i] = "0";
				}
				if (!sj.panduanzifu(fenshu2[i])) {
					qwe1 = false;
					break;
				}
			}
			for (int i = 0; i < xueke.length; i++) {
				if (sj.panduanzifu(tishu2[i])){
				it = Integer.parseInt(tishu2[i]);}
				if (it > sj.zuchengshijuan(xueke[i], tixing[i])) {
					qwe2 = false;
					break;
				}
			}
			for (int i = 0; i < xueke.length; i++) {
				for (int j = i + 1; j < xueke.length; j++) {
					if (xueke[i].equals(xueke[j])
							&& tixing[i].equals(tixing[j])) {
						qwe3 = false;
						break;
					}
				}
			}
			
				if (qwe == false) {
					out.print("{\"result\":\"2\"}");
				} else {
					if (qwe1 == false) {
						out.print("{\"result\":\"3\"}");
					} else {
						if (qwe2 == false) {
									out.print("{\"result\":\"4\"}");

						} else {
							if (qwe3 == false) {
								out.print("{\"result\":\"5\"}");
								
							} else {
								sj.setshijuanming(shijuanming);
								int sjid = sj.getshijuanming(shijuanming);
								for (int i = 0; i < xueke.length; i++) {
									int count = sj.zuchengshijuan(xueke[i],
											tixing[i]);
									Set set = new HashSet();
									int tishu = Integer.parseInt(tishu2[i]);
									set = sj.zuchengshijuan(tishu, count);
									Iterator it2 = set.iterator();
									int fenshu = Integer.parseInt(fenshu2[i]);
									while (it2.hasNext()) {

										int tihao = sj.gettihao(Integer
												.parseInt(String.valueOf(it2
														.next())), xueke[i],
												tixing[i]);

										sj.zuchengshijuan(tihao, sjid, fenshu);

									}
								}

								out.print("{\"result\":\"10\"}");
								

							}
						}
					}
				}
			}
		}
out.close();}
}
