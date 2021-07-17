package cn.sdut.dao;
 
import  java.sql.*;

import java.sql.Statement;
 
public class BaseDao {
   // 1 定义数据库访问公共变量
   Connection con;
   PreparedStatement pst;
   ResultSet rs;
   // 2 定义数据库的链接方法
   public Connection getConn() {
      // 1 加载jdbc驱动
 
      try {
         Class.forName("com.mysql.jdbc.Driver");
      }catch(ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      Connection con = null;
	// 2 得到数据库的链接
      try {
    	  con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/school?useSSL=false", "root", "admin");
      }catch(Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return con;
   }
 
   // 3 关闭conn,pst,rs
   public void closeAll() {
      try {
		if (rs !=null) {
			rs.close();
         }
         if (pst !=null) {
            pst.close();
         }
         if (con !=null) {
            ((Connection) con).close();
         }
      }catch(SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}