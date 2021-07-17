<%@ page language="java" import="java.util.*"
    contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPEhtmlPUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
<title>增加学生</title>
</head>
<body>
    <form action="doAdd.jsp"method="post">
       <table>
           <caption>增加学生</caption>
            <tr>
              <td>学号：</td>
              <td><input type="text"name="id"/></td>
           </tr>
           <tr>
              <td>姓名：</td>
              <td><input type="text"name="name"/></td>
           </tr>
           <tr>
              <td>出生年月：</td>
              <td><input type="text"name="birthday"/></td>
           </tr>
           <tr>
              <td>成绩:</td>
              <td><input type="text"name="score"/></td>
           </tr>
           <tr align="center">
              <td colspan="2"><input type="submit"value="确定"/><input
                  type="reset"value="取消"/></td>
           </tr>
       </table>
    </form>
</body>
</html>
