package com.neusoft.util;

import java.sql.Connection;
import java.util.List;
import java.util.regex.Pattern;

import com.neusoft.db.DBManager;
import com.neusoft.db.JdbcTemplate;
import com.neusoft.mapping.EntityMapping;

public class OraclePagination implements Pagination {
	// 分页大小
	private int pageSize = 5;
	// 当前要显示的页码
	private int pageNumber = 1;
	// 最大页码
	private int maxPages;
	// 最大记录数
	private int maxElements;
	private String sql;
	private DBManager db;
	private JdbcTemplate jtm;
	private Connection conn;

	// private EntityMapping mapping;
	//初始化，连接数据库
	public OraclePagination(String sql) {
		this.sql = sql;
		init();
	}
	
	/**
	 * 构造器：传SQL语句，pageSize：每页记录条数；pageNumber：当前选择页
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

	// 获得最大的记录数
	private void setMaxElements() {
		// select * from xxx order by desc
		// select count(1) from xxx order by desc

		String regex = "select((.)+)from";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		String[] s = p.split(this.sql);
		String newSql = "select count(1) as total from " + s[1];

		this.maxElements = jtm.query(newSql);
	}

	// 总页数，不足2页也算2页
	// 最大记录数/分页大小
	private void setMaxPages() {
		if (maxElements != 0 && (maxElements % pageSize == 0)) {
			maxPages = maxElements / pageSize;
		} else {
			maxPages = maxElements / pageSize + 1;
		}
	}

	/**
	 * 在原有的sql基础上利用rownum通过子查询返回一个区间内的结果集 source 原有的sql begin 结果集开始点 end 结果集结束点
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

	// ***********根据页码查找片断记录的起始索引***************start
	private int getEndElement() {
		int endElement = pageNumber * pageSize;
		if (endElement >= maxElements) {
			return maxElements;
		} else {
			return endElement;
		}
	}

	private int getBeginElement() {
		// 如果传进来5页那么起始就应该是4页整
		return (pageNumber - 1) * pageSize + 1;
	}

	// ***********根据页码查找片断记录的起始索引***************end

	public List<Object> getList(EntityMapping mapping) {
		// 计算list的起始索引
		String newSql = this.sqlModify(this.sql, this.getBeginElement(), this
				.getEndElement());
		return (List) jtm.query(newSql, mapping);
	}

	// public List<Object> getList(EntityMapping mapping) {
	// // mapping =
	// MappingFactory.getInstance().getMapping(MappingFactory.ADMIN_MAPPING);
	// // 计算list的起始索引
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

	// 返回下一页，如果当页就是最后一页，返回这页的数字
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
