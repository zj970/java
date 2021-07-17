<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme() + "://"
         +request.getServerName() + ":" + request.getServerPort()
         +path + "/";
%>
 
<!DOCTYPEHTMLPUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
 
<title>My JSP 'delStudent.jsp'starting page</title>
 
<meta http-equiv="pragma"content="no-cache">
<meta http-equiv="cache-control"content="no-cache">
<meta http-equiv="expires"content="0">
<meta http-equiv="keywords"content="keyword1,keyword2,keyword3">
<meta http-equiv="description"content="This is my page">
<!--
   <linkrel="stylesheet" type="text/css"href="styles.css">
   -->
 
</head>
 
<body>
   <form action="doDel.jsp"method="post">
   <table>
      <caption>删除学生</caption>
      <tr>
         <td>序号：</td>
         <td><input type="text"name="id"></td>
      </tr>
      <tr>
         <td align="center"colspan="2"><input type="submit"value="确认"><input
            type="reset"value="取消"></td>
      </tr>
   </table>
   </form>
</body>
</html>