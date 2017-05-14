package com.neuedu.examonline.report.export;

public class StudentQuery {
	private String student_id;
	private String name;
	private String class_name;
	
	private String exam_id;
	private String exam_name;
	private String start_time;
	
	private double kg_score;
	private double zg_score;
	private double student_score;
	
	
	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getClass_name() {
		return class_name;
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}


	public void add(double a,double b)
	{
		this.student_score=a+b;
	}
	
	
	public double getStudent_score() {
		return student_score;
	}


	public void setStudent_score(double student_score) {
		this.student_score = student_score;
	}


	public void setKg_score(double kg_score) {
		this.kg_score = kg_score;
	}


	public void setZg_score(double zg_score) {
		this.zg_score = zg_score;
	}


	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}


	public double getKg_score() {
		return kg_score;
	}


	public double getZg_score() {
		return zg_score;
	}


}
