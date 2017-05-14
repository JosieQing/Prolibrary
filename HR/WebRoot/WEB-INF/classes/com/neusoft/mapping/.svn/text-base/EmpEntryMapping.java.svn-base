package com.neusoft.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.bean.EmpEntry;

public class EmpEntryMapping implements EntityMapping{
	public Object mapping(ResultSet rs) throws SQLException {
		EmpEntry ee=new EmpEntry();
		ee.setEid(rs.getInt("eid"));
		ee.setEname(rs.getString("ename"));
		ee.setSex(rs.getString("sex"));
		String t = rs.getString("sex");
		if(t.equals("1")) {
			ee.setSex("男");
		}
		else if(t.equals("0")){
			ee.setSex("女");
		}
		ee.setCard(rs.getString("card"));
		ee.setDeptno(rs.getInt("deptno"));
		ee.setDname(rs.getString("dname"));
		ee.setJobno(rs.getInt("jobno"));
		ee.setWorkDay(rs.getDate("workDay"));
		ee.setEmpForm(rs.getString("empForm"));
		ee.setJname(rs.getString("jname"));
		ee.setPersonSource(rs.getString("personSource"));
		ee.setPoliticStatus(rs.getString("politicStatus"));
		ee.setNationalCity(rs.getString("nationalCity"));
		ee.setNativePlace(rs.getString("nativePlace"));
		ee.setPhone(rs.getString("phone"));
		ee.setEmail(rs.getString("email"));
		ee.setHeight(rs.getString("height"));
		ee.setBloodType(rs.getString("bloodType"));
		ee.setMarriage(rs.getString("marriage"));
		ee.setBirthPlace(rs.getString("birthPlace"));
		ee.setResidentPlace(rs.getString("residentPlace"));
		ee.setHighestEducation(rs.getString("highestEducation"));
		ee.setHighestOffering(rs.getString("highestOffering"));
		ee.setGraduateSchool(rs.getString("graduateSchool"));
		ee.setMajor(rs.getString("major"));
		ee.setGraduateDay(rs.getDate("graduateDay"));
		ee.setForeignLanguage(rs.getString("foreignLanguage"));
		ee.setCareer(rs.getString("career"));
		ee.setFamilyRelationship(rs.getString("familyRelationship"));
		ee.setSocialRelationship(rs.getString("socialRelationship"));
		ee.setIdStyle(rs.getString("idStyle"));
		ee.setFormalDay(rs.getDate("formalDay"));
		ee.setProbationDay(rs.getDate("probationDay"));
		ee.setBirthday(rs.getDate("birthday"));
		String t1 = rs.getString("state");
		if(t1.equals("0")) {
			ee.setState("没有试用期");
		}
		else if(t1.equals("1")){
			ee.setState("试用期");
		}else if(t1.equals("2")){
			ee.setState("离职");
		}
		else if(t1.equals("3")){
			ee.setState("转正");
		}
		return ee;
	}

}
