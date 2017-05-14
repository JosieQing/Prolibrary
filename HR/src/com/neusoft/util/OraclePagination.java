package com.neusoft.util;

import java.sql.Connection;
import java.util.List;
import java.util.regex.Pattern;

import com.neusoft.db.DBManager;
import com.neusoft.db.JdbcTemplate;
import com.neusoft.mapping.EntityMapping;

public class OraclePagination implements Pagination {
	// ��ҳ��С
	private int pageSize = 5;
	// ��ǰҪ��ʾ��ҳ��
	private int pageNumber = 1;
	// ���ҳ��
	private int maxPages;
	// ����¼��
	private int maxElements;
	private String sql;
	private DBManager db;
	private JdbcTemplate jtm;
	private Connection conn;

	// private EntityMapping mapping;
	//��ʼ�����������ݿ�
	public OraclePagination(String sql) {
		this.sql = sql;
		init();
	}
	
	/**
	 * ����������SQL��䣬pageSize��ÿҳ��¼������pageNumber����ǰѡ��ҳ
	 * @param sql
	 * @param pageSize
	 * @param pageNumber
	 */
	public OraclePagination(String sql, int pageSize, int pageNumber) {
		this.sql = sql;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		init();
		this.setPageNumber(pageNumber);
	}
	
	private void init() {
		db = DBManager.getInstance();
		conn = db.getConnection();
		jtm = JdbcTemplate.getInstance();
		jtm.setConnection(conn);
		setMaxElements();
		setMaxPages();
	}

	// ������ļ�¼��
	private void setMaxElements() {
		// select * from xxx order by desc
		// select count(1) from xxx order by desc

		String regex = "select((.)+)from";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		String[] s = p.split(this.sql);
		String newSql = "select count(1) as total from " + s[1];

		this.maxElements = jtm.query(newSql);
	}

	// ��ҳ��������2ҳҲ��2ҳ
	// ����¼��/��ҳ��С
	private void setMaxPages() {
		if (maxElements != 0 && (maxElements % pageSize == 0)) {
			maxPages = maxElements / pageSize;
		} else {
			maxPages = maxElements / pageSize + 1;
		}
	}

	/**
	 * ��ԭ�е�sql����������rownumͨ���Ӳ�ѯ����һ�������ڵĽ���� source ԭ�е�sql begin �������ʼ�� end �����������
	 */
	private String sqlModify(String source, int begin, int end) {
		StringBuffer target = new StringBuffer(200);
		target.append("select * from (select a.*,rownum r from (");
		target.append(sql);
		target.append(") a where rownum <=");
		target.append(end);
		target.append(") where r>=");
		target.append(begin);
		return target.toString();
	}

	// ***********����ҳ�����Ƭ�ϼ�¼����ʼ����***************start
	private int getEndElement() {
		int endElement = pageNumber * pageSize;
		if (endElement >= maxElements) {
			return maxElements;
		} else {
			return endElement;
		}
	}

	private int getBeginElement() {
		// ���������5ҳ��ô��ʼ��Ӧ����4ҳ��
		return (pageNumber - 1) * pageSize + 1;
	}

	// ***********����ҳ�����Ƭ�ϼ�¼����ʼ����***************end

	public List<Object> getList(EntityMapping mapping) {
		// ����list����ʼ����
		String newSql = this.sqlModify(this.sql, this.getBeginElement(), this
				.getEndElement());
		return (List) jtm.query(newSql, mapping);
	}

	// public List<Object> getList(EntityMapping mapping) {
	// // mapping =
	// MappingFactory.getInstance().getMapping(MappingFactory.ADMIN_MAPPING);
	// // ����list����ʼ����
	// String newSql = this.sqlModify(this.sql, this.getBeginElement(), this
	// .getEndElement());
	// return (List) jtm.query(newSql, mapping);
	// }

	public int getMaxElements() {
		// TODO Auto-generated method stub
		return maxElements;
	}

	public int getMaxPages() {
		return maxPages;
	}

	// ������һҳ�������ҳ�������һҳ��������ҳ������
	public int getNext() {
		if (pageNumber + 1 >= this.getMaxPages()) {
			return getMaxPages();
		}
		return pageNumber + 1;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPrevious() {
		if (pageNumber - 1 <= 1) {
			return 1;
		} else {
			return pageNumber - 1;
		}
	}

	public boolean hasNext() {
		return pageNumber < this.getMaxPages();
	}

	public boolean hasPrevious() {
		return pageNumber > 1;
	}

	public boolean isFirst() {
		return pageNumber == 1;
	}

	public boolean isLast() {
		return pageNumber >= this.getMaxPages();
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber > maxPages) {
			this.pageNumber = maxPages;
		} else if (pageNumber < 1) {
			this.pageNumber = 1;
		} else {
			this.pageNumber = pageNumber;
		}

	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;

	}

	/*
	 * select * from (select rownum rid,user_id,user_name,user_salary from
	 * (select info.user_name,salary.*
	 * 
	 * from info, salary
	 * 
	 * where info.user_id=salary.user_id
	 * 
	 * order by info.user_id )Where Rownum<=10 ) where rid >=5
	 */

	public static void main(String[] args) {
		Pagination pg = new OraclePagination("select * from emp",3,1);
		System.out.println(pg.getMaxElements());
		System.out.println(pg.getMaxPages());
	}

}
