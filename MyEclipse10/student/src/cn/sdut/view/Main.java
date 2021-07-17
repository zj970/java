package cn.sdut.view;
 
//import java.util.Iterator;
import java.util.List;
 
import cn.sdut.dao.StudentDao;
import cn.sdut.po.Student;
import java.sql.*;
public class Main {
   public static void main(String[] args) {
      StudentDao studentDao = new StudentDao();
      Student student = new Student();
      //studentDao.creat();
      /*student.setId(2);
      student.setName("xueba");
      student.setBirthday("1995-1-1");
      student.setScore(77);
      studentDao.add(student);*/
      student.setId(2);
      student.setName("66");
      student.setBirthday("1999-1-1");
      student.setScore(88);
     
      //studentDao.add(student);
     
      //studentDao.del(4);
     
      studentDao.updata(student);
      List<Student>students = studentDao.queryAll();
     
       for(Student stu:students){System.out.println(stu); }
       
      /*for(Iterator<Student> stu = students.iterator(); stu.hasNext();) {
         System.out.println(stu);
      }*/
   }
}
