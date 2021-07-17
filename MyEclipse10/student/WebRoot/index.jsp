<%@page import="cn.sdut.po.Student"%>
<%@page import="cn.sdut.dao.StudentDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme() + "://"
         +request.getServerName() + ":" + request.getServerPort()
         +path + "/";
%>
<%
   StudentDao st=new StudentDao();
   List<Student>stuList = st.queryAll();
    %>
<!DOCTYPEHTMLPUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
 
<title>My JSP'index.jsp' starting page</title>
<meta http-equiv="pragma"content="no-cache">
<meta http-equiv="cache-control"content="no-cache">
<meta http-equiv="expires"content="0">
<meta http-equiv="keywords"content="keyword1,keyword2,keyword3">
<meta http-equiv="description"content="This is my page">
<!--
   <linkrel="style sheet" type="texts"href="styles.css">
   -->
</head>
 
<body>
<center>
   <table border="1">
      <tr>
         <th width="50">序号</th>
         <th width="50">姓名</th>
         <th width="100">出生年月</th>
         <th width="50">成绩</th>
      </tr>
   <%
         for (Student stu : stuList){
            out.print("<tr>");
            out.print("<td>");
            out.print(stu.getId());
            out.print("</td>");
           
            out.print("<td>");
            out.print(stu.getName());
            out.print("</td>");
           
            out.print("<td>");
            out.print(stu.getBirthday());
            out.print("</td>");
            out.print("<td>");
            out.print(stu.getScore());
            out.print("</td>");
            out.print("</tr>");
         }
      %>
   </table>
   <ul>
      <li><a href="addStudent.jsp">增加学生</a><>
      <li><a href="delStuden.jsp">删除学生</a><>
      <li><a href="MyJsp.jsp">更新信息</a><>
      </center>
</body>
<ml>