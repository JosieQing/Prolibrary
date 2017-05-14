package com.neuedu.examonline.paper.select;

public class Question {
	private String num;
	private String questiontext; 
	private String a;           
	private String b;           
	private String c;            
	private String d;          
	private String e;

	private String id;

	private String types_name;
	private String boss;
	private String COUSE;
	
	public Question(){}
	
	public Question(String questiontext, String id, String types_name,
			String boss, String cOUSE) {
		super();
		this.questiontext = questiontext;
		this.id = id;
		this.types_name = types_name;
		this.boss = boss;
		COUSE = cOUSE;
	}

	public Question(String num, String questiontext) {
		super();
		this.num = num;
		this.questiontext = questiontext;
	}

	public Question(String num, String questiontext, String a, String b,
			String c, String d, String e) {
		super();
		this.num = num;
		this.questiontext = questiontext;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getQuestiontext() {
		return questiontext;
	}
	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypes_name() {
		return types_name;
	}

	public void setTypes_name(String types_name) {
		this.types_name = types_name;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	public String getCOUSE() {
		return COUSE;
	}

	public void setCOUSE(String cOUSE) {
		COUSE = cOUSE;
	}

}
