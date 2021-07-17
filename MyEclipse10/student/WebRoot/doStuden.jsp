<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.sdut.dao.StudentDao"%>
<%@page import="cn.sdut.po.Student"%>
<!DOCTYPEhtmlPUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
<title>Insert titlehere</title>
</head>
<body>
    <%
       //1 接受客户端传来的数据并封装成Student类的对象
 
       request.setCharacterEncoding("utf-8");
       String name = request.getParameter("name");
       String birthday = request.getParameter("birthday");
       String score1 = request.getParameter("score");
       float score = Float.parseFloat(score1);
       Student student = new Student();
       student.setName(name);
       student.setBirthday(birthday);
       student.setScore(score);
 
       //2 调用StudentDao的add方法,向数据库表中增加记录
       StudentDao studentDao = new StudentDao();
       studentDao.add(student);
 
       //3 转向index.jsp,展示最新的表中的数据
       response.sendRedirect("index.jsp");
    %>
</body>
</html>