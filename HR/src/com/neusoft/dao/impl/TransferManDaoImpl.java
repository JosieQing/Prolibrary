package com.neusoft.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.neusoft.bean.TransferMan;
import com.neusoft.dao.TransferManDao;
import com.neusoft.mapping.EntityMapping;
import com.neusoft.util.OraclePagination;
import com.neusoft.util.Pagination;

public class TransferManDaoImpl extends BaseDAO implements TransferManDao {

	/**
	 * 增加调动信息
	 */
	public boolean addTransferInfo(TransferMan tm) {

		if (tm.getTmType().equals("数据录入错误")) {
			return false;
		} else {
			
			String sql = "INSERT INTO TransferMan VALUES(NB_TMID.nextval,?,?,?,?,?,to_date('"
					+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "','yyyy-MM-dd'),?,?)";
			int row = jdbcTemplate.update(sql, tm.getEid(), tm.getNewDname(),
					tm.getNewJname(), tm.getTmType(), tm.getReason(), tm
							.getOldDname(), tm.getOldJname());
			return row == 1;
		}
	}

	/**
	 * 根据EID查询员工调动信息
	 * 
	 * @param eid
	 * @return
	 */
	public TransferMan getTransferInfoByEid(int eid) {

		String sql = "SELECT * FROM TransferMan WHERE EID = ?";
		EntityMapping mapping = mappingFactory
				.getMapping(mappingFactory.TRANSFERMAN_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping, eid);

		if (list.size() > 0) {
			return (TransferMan) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 查询所有调动信息
	 */
	public List<TransferMan> getAllTransferInfo() {

		String sql = "SELECT * FROM TransferMan";
		EntityMapping mapping = mappingFactory
				.getMapping(mappingFactory.TRANSFERMAN_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		List<TransferMan> lists = new ArrayList<TransferMan>();
		for (int i = 0; i < list.size(); i++) {
			TransferMan tm = (TransferMan) list.get(i);
			lists.add(tm);
		}
		return lists;
	}

	/**
	 * 分页
	 * 
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	public Pagination getTransferInfoByPage(int pageSize, int pageNumber) {

		String sql = "select * from TransferMan order by tmid";
		Pagination p = new OraclePagination(sql, pageSize, pageNumber);
		return p;
	}

	/**
	 * 分页--条件
	 */
	public Pagination getTransferInfoByPage(String eid, String tmType,
			String startDay, String endDay, int pageSize, int pageNumber) {

		StringBuffer sql = new StringBuffer("SELECT * FROM TRANSFERMAN");
		StringBuffer connect = new StringBuffer();
		if (eid != null && !eid.equals("")) {
			connect.append(" AND EID LIKE '" + "%" + eid + "%'");
		}
		if (tmType != null && !tmType.isEmpty()) {
			if (tmType.equals("1")) {
				connect.append("");

			} else {
				connect.append(" AND tmType = " + tmType);

			}
		}
		if (startDay != null && !startDay.isEmpty()) {
			connect.append(" AND TMDATE >= TO_DATE('" + startDay
					+ "','yyyy-MM-dd')");
		}
		if (endDay != null && !endDay.isEmpty()) {
			connect.append(" AND TMDATE <= TO_DATE('" + endDay
					+ "','yyyy-MM-dd')");
		}
		if (!connect.toString().isEmpty() && connect.toString() != null) {

			connect.delete(0, 4);
			connect.insert(0, " WHERE");
		}
		sql.append(connect);

		Pagination p = new OraclePagination(sql.toString(), pageSize,
				pageNumber);
		return p;
	}

}
