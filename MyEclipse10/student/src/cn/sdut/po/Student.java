package cn.sdut.po;
 
public class Student {
   private int id;
   private String name;
   private String birthday;
   private float score;
  
   public void setBirthday(String birthday) {
         this.birthday = birthday;
      }
   public void setId(int id) {
      this.id = id;
   }
   public void setName(String name) {
      this.name = name;
   }
   public void setScore(float score) {
      this.score = score;
   }
   public String getBirthday() {
      return birthday;
   }
   public String getName() {
      return name;
   }
   public float getScore() {
      return score;
   }
   public int getId() {
      return id;
   }
   @Override
   public String toString() {
      return "Student [id="+ id + ", name="+ name+ ", birthday="
            +birthday+ ", score=" + score+ "]";
   }
}