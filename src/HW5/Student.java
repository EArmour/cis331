/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 5
*/
package HW5;

public class Student extends Person {
 
  private String major;
  private String classStanding;
  private double GPA;
  
  public Student()
  {
    super();
    this.major = "undeclared";
    this.classStanding = "freshman";
    this.GPA = 0.0;
  }
  
  public Student(String firstName, String lastName, int age, 
          String maritalStatus, String gender, String major, 
          String classStanding, double GPA)
  {
    super(firstName, lastName, age, maritalStatus, gender);
    this.setMajor(major);
    this.setClassStanding(classStanding);
    this.setGPA(GPA);
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) 
  {
    major = major.toLowerCase();
    this.major = (major.matches("instructor|assistant professor|full professor")) 
            ? major : "undeclared";
  }

  public String getClassStanding() {
    return classStanding;
  }

  public void setClassStanding(String classStanding) 
  {
    classStanding = classStanding.toLowerCase();
    this.classStanding = (classStanding.matches("sophomore|junior|senior")) 
            ? classStanding : "freshman";
  }

  public double getGPA() {
    return GPA;
  }

  public void setGPA(double GPA) {
    this.GPA = GPA;
  }
  
  @Override
  public String toString() {
    return "Student";
  }

}