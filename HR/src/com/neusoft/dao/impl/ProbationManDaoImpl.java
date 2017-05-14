package com.neusoft.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.neusoft.bean.EmpEntry;
import com.neusoft.bean.ProbationMan;
import com.neusoft.dao.ProbationManDao;
import com.neusoft.mapping.EntityMapping;
import com.neusoft.mapping.MappingFactory;
import com.neusoft.util.OraclePagination;
import com.neusoft.util.Pagination;
import com.sun.jndi.url.dns.dnsURLContext;

/**
 * ProbationManDaoImpl实现接口ProbationManDao
 * 
 * @author ttc
 */
public class ProbationManDaoImpl extends BaseDAO implements ProbationManDao {


	/**
	 * 根据ID获取员工信息
	 */
	public EmpEntry getEmpMessageById(Integer eid) {
		String sql = "SELECT * FROM employee WHERE eid = ? AND EMPFORM = '临时员工'";
		EntityMapping mapping = mappingFactory
				.getMapping(MappingFactory.EmpEntry_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping, eid);
		EmpEntry ee = null;
		for (int i = 0; i < list.size(); i++) {
			ee = (EmpEntry) list.get(i);
		}
		return ee;
	}

	/**
	 * 试用期信息简单录入
	 * 
	 * @param pm
	 * @return
	 */
	public boolean addProbationInfo(ProbationMan pm) {

		String sql = "INSERT INTO ProbationMan(PMID,EID,PROBATIONDAY,PROBATIONTIME,ENDDAY,STATE) "
				+ "VALUES(NB_PMID.nextval,?,?,?,ADD_MONTHS( (to_date('"
				+ pm.getProbationDay()
				+ "','yyyy-MM-dd')),"
				+ pm.getProbationTime() + "),'试用中')";
		int row = jdbcTemplate.update(sql, pm.getEid(), pm.getProbationDay(),
				pm.getProbationTime());
		return row == 1;

	}
	/**
	 * 试用期信息管理
	 * 
	 * @param pm
	 * @param eid
	 * @return
	 */
	public boolean probationManInfo(ProbationMan pm, Integer eid) {
		String sql = null;
		String addsql1 = null;
		if (pm.getResult().equals("转正")) {
			sql = "UPDATE ProbationMan SET REMARKS = ?,RESULT = ?,FORMALDAY = to_date('"
					+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "','yyyy-MM-dd'),STATE = '已转正'  WHERE EID = ?";
			addsql1 = "UPDATE employee SET STATE = 2 WHERE eid = " + eid;
		} else if (pm.getResult().equals("延期一个月")) {
			sql = "UPDATE ProbationMan SET REMARKS = ?,RESULT = ?,DELAYDAY = to_date('"
					+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "','yyyy-MM-dd'),STATE = '延期中',ENDDAY = ADD_MONTHS(ENDDAY,1)WHERE EID = ?";
		} else {
			sql = "UPDATE ProbationMan SET REMARKS = ?,RESULT = ?,LEAVEDAY = to_date('"
					+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "','yyyy-MM-dd'),STATE = '未录用' WHERE EID = ?";
			addsql1 = "UPDATE employee SET STATE = 3   WHERE eid = " + eid;
		}
		int row1 = jdbcTemplate.update(sql, pm.getRemarks(), pm.getResult(),
				eid);
		int row2 = 0;
		if (addsql1 != null) {
			row2 = jdbcTemplate.update(addsql1);
		}
		return row1 == 1;

	}

	/**
	 * 通过员工编号查询试用信息
	 */
	public ProbationMan getProbationInfoByEid(Integer eid) {
		String sql = "SELECT * FROM ProbationMan WHERE EID = ?";
		EntityMapping mapping = mappingFactory
				.getMapping(mappingFactory.PROBATIONMAN_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping, eid);

		if (list.size() > 0) {
			return (ProbationMan) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 分页---pageSize：每页记录条数；pageNumber：当前选择页
	 */
	public Pagination getProbationManByPage(String eid, String state,
			int pageSize, int pageNumber) {

		StringBuffer sql = new StringBuffer("SELECT * FROM PROBATIONMAN");
		StringBuffer connect = new StringBuffer();

		if (eid != null && !eid.equals("")) {
			connect.append(" AND EID LIKE '" + "%" + eid + "%'");
		}
		if (!(state.equals("")) && !(state.isEmpty())) {
			if (state.equals("1")) {
				connect.append("");
			} else {
				connect.append(" AND STATE = '" + state + "'");
			}
		}
		connect.delete(0, 4);
		if (!connect.toString().equals("")) {
			connect.insert(0, " WHERE");
		}
		sql.append(connect);
		String sql1 = sql.toString();
		Pagination p = new OraclePagination(sql1, pageSize, pageNumber);
		return p;
	}

}
