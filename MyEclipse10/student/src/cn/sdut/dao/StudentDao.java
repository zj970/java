package cn.sdut.dao;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 
import cn.sdut.po.Student;
 
public class StudentDao extends BaseDao {
   //建立student表
   //public boolean creat() {
     // boolean result = false;
 
     // try {
        // con = getConn();
         //String sql = "create table student(id int(10) primary key auto_increment,name varchar(20) not null,birthday date,score float(1));";
        //pst= con.prepareStatement(sql);
        // result = pst.execute();
     // } catch (SQLException e) {
         // TODO Auto-generated catch block
        // e.printStackTrace();
     // }
      //return result;
  // }
   // 增
   public int add(Student stu) {
      int result = 0;
      try {
         con = getConn();
         String sql = "insert into student(name,birthday,score,id) values(?,?,?,?)";
         pst = con.prepareStatement(sql);
         pst.setString(1, stu.getName());
         pst.setString(2, stu.getBirthday());
         pst.setFloat(3, stu.getScore());
         pst.setInt(4, stu.getId());
         result = pst.executeUpdate();// 可执行DML类型（insert,updata,delete），返回更新所影响的行数
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         closeAll();
      }
      return result;
   }
 
   // 删
   public int del(int id) {
      int result = 0;
 
      try {
         con = getConn();
         String sql = "delete from student where id=?";
         pst = con.prepareStatement(sql);
         pst.setInt(1, id);
         result = pst.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return result;
   }
 
   // 改
   public int updata(Student stu) {
      int result = 0;
 
      try {
         con = getConn();
         String sql = "update student set name=?,birthday=?,score=?  where id=?";
         pst = con.prepareStatement(sql);
         pst.setString(1, stu.getName());
         pst.setString(2, stu.getBirthday());
         pst.setFloat(3, stu.getScore());
         pst.setInt(4, stu.getId());
         result = pst.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         closeAll();
      }
      return result;
   }
 
   // 查
   public List<Student> queryAll() {
      List<Student> students = new ArrayList<Student>();
 
      try {
         con = getConn();
         String sql = "select * from student";
 
         pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery();
         while (rs.next()) {
            Student stu = new Student();
            stu.setId(rs.getInt(1));
            stu.setName(rs.getString(2));
            stu.setBirthday(rs.getString(3));
            stu.setScore(rs.getFloat(4));
            students.add(stu);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         closeAll();
      }
      return students;
   }
}
