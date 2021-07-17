<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action="updata.jsp"method="post">
      <table>
         <caption>更新信息</caption>
         <tr>
            <td>序号：</td>
            <td><input type="text"name="id"></td>
         </tr>
         <tr>
            <td>姓名：</td>
            <td><input type="text"name="name"></td>
         <tr>
            <td>出生年月：</td>
            <td><input type="text"name="birthday"></td>
         <tr>
            <td>分数：</td>
            <td><input type="text"name="score"></td>
         </tr>
         <tr>
            <td align="center"colspan="2"><input type="submit"value="确定"><input
                type="reset"value="取消"></td>
      </table>
   </form>
  </body>
</html>
