<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.sdut.dao.StudentDao" %>
<%
String path =request.getContextPath();
String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPEHTMLPUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN">
<html>
 <head>
   <base href="<%=basePath%>">
   
   <title>My JSP 'doDel.jsp' starting page</title>
   
   <meta http-equiv="pragma"content="no-cache">
   <meta http-equiv="cache-control"content="no-cache">
   <meta http-equiv="expires"content="0">   
   <meta http-equiv="keywords"content="keyword1,keyword2,keyword3">
   <meta http-equiv="description"content="This is my page">
   <!--
   <linkrel="style sheet" type="text/css"href="styles.css">
   -->
 
 </head>
 
 <body>
   <%
      request.setCharacterEncoding("utf-8");
      String ids=request.getParameter("id");
      int id = Integer.parseInt(ids);
      StudentDao stuDao=new StudentDao();
      stuDao.del(id);
      response.sendRedirect("index.jsp");
    %>
 </body>
</html>
