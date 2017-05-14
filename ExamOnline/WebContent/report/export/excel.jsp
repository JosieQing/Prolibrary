<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="" %>
<%@ page import="org.apache.poi.hssf.usermodel.HSSFCell" %>
<%@ page import="org.apache.poi.hssf.usermodel.HSSFCellStyle" %>
<%@ page import="org.apache.poi.hssf.usermodel.HSSFRow" %>
<%@ page import="org.apache.poi.hssf.usermodel.HSSFSheet" %>
<%@ page import="org.apache.poi.hssf.usermodel.HSSFWorkbook" %>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.neuedu.examonline.report.export.*"%>

<%
	

	HSSFWorkbook wb=null;
	if(wb == null){

	wb = new HSSFWorkbook();

}
List liii=(List)session.getAttribute("Liii");
// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
HSSFSheet sheet = wb.createSheet("sheet");  
// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
HSSFRow row = sheet.createRow(0);  
// 第四步，创建单元格，并设置值表头 设置表头居中  
HSSFCellStyle style = wb.createCellStyle();  
style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  

//HSSFCell cell = null; 
HSSFCell cell1 = row.createCell(0);
cell1.setCellValue("学生");
cell1.setCellStyle(style);

HSSFCell cell2 = row.createCell(1);
cell2.setCellValue("学生姓名");
cell2.setCellStyle(style);

HSSFCell cell3 = row.createCell(2);
cell3.setCellValue("班级");
cell3.setCellStyle(style);

HSSFCell cell4 = row.createCell(3);
cell4.setCellValue("考试名称");
cell4.setCellStyle(style);

HSSFCell cell5 = row.createCell(4);
cell5.setCellValue("考试id");
cell5.setCellStyle(style);

HSSFCell cell6 = row.createCell(5);
cell6.setCellValue("考试时间");
cell6.setCellStyle(style);

HSSFCell cell7 = row.createCell(6);
cell7.setCellValue("分数");
cell7.setCellStyle(style);


//创建标题
//for(int i=0;i<title.length;i++){
//    cell = row.createCell(i);  
//    cell.setCellValue(title[i]);  
//    cell.setCellStyle(style);  
//}

if(liii!=null){
int i=1;
Iterator it = liii.listIterator();
while(it.hasNext()){
	StudentQuery saa=(StudentQuery)it.next();
	HSSFRow row1 = sheet.createRow(i);
	
	HSSFCell cell11 = row1.createCell(0);
	cell11.setCellValue(saa.getStudent_id());
	cell11.setCellStyle(style);

	HSSFCell cell21 = row1.createCell(1);
	cell21.setCellValue(saa.getName());
	cell21.setCellStyle(style);

	HSSFCell cell31 = row1.createCell(2);
	cell31.setCellValue(saa.getClass_name());
	cell31.setCellStyle(style);

	HSSFCell cell41 = row1.createCell(3);
	cell41.setCellValue(saa.getExam_name());
	cell41.setCellStyle(style);
	
	HSSFCell cell51 = row1.createCell(4);
	cell51.setCellValue(saa.getExam_id());
	cell51.setCellStyle(style);
	
	HSSFCell cell61 = row1.createCell(5);
	cell61.setCellValue(saa.getStart_time());
	cell61.setCellStyle(style);
	
	HSSFCell cell71 = row1.createCell(6);
	cell71.setCellValue(saa.getStudent_score());
	cell71.setCellStyle(style);
	
	
	
	i++;

}
}

//创建内容
//for(int i=0;i<values.length;i++){
//row = sheet.createRow(i + 1); 
//for(int j=0;j<values[i].length;j++){
//     row.createCell(j).setCellValue(values[i][j]);
//}
//}

try {
	String real=request.getRealPath("");
	System.out.println(real);
	wb.write(new java.io.FileOutputStream(real+"\\Files\\Excel.xls"));
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
out.print("<a href='"+basePath+"Files/Excel.xls'>excel</a>");
%>