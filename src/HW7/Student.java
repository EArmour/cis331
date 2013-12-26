/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 7
*/
package HW7;

public class Student extends Person {

  public static int totStudents = 0;
  public static int[] students = new int[100];
  
  private String major;
  private String classStanding;
  private double GPA;
  
  public Student()
  {
    super();
    this.major = "UD";
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
  
public static boolean addStudent(String firstName, String lastName, int age, 
          String maritalStatus, String gender, String major, 
          String classStanding, double GPA) 
  {
    if (totPeople == MAXPEOPLE)
      return false;
    
    people[totPeople] = new Student(firstName, lastName, age, 
            maritalStatus, gender, major, classStanding, GPA);
    students[totStudents] = totPeople;
    
    totStudents++;
    totPeople++;
    return true;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) 
  {
    this.major = major;
  }

  public String getClassStanding() {
    return classStanding;
  }

  public void setClassStanding(String classStanding) 
  {
    classStanding = classStanding.toLowerCase();
    this.classStanding = classStanding.matches("sophomore|junior|senior")
            ? classStanding : "freshman";
  }

  public double getGPA() {
    return GPA;
  }

  public void setGPA(double GPA) {
    this.GPA = (GPA > 0.0 && GPA <= 4.0) ? GPA : 0.0;
  }

  @Override
  public String personInfo(boolean fullData)
  {
    String info = super.personInfo(false);
    if (fullData)
      info = super.personInfo(true) + "\tMajor: " + this.getMajor() + 
              "\tStanding: " + this.getClassStanding() + 
              "\tGPA: " + this.getGPA();
    
    return info;
  }
  
  public static String showOverallGPA()
  {
    double avg = 0.0D;
    int students = 0;
    
    for(int i=0; i < totPeople; i++)
    {
      if(people[i].toString().equals("Student"))
      {
        avg += ((Student)people[i]).getGPA();
        students++;
      }
    }
    
    if(students == 0)
      return "There are no students to get the GPA of!";
 
    return "There are " + students + " students, with an average GPA of " + 
            (avg/students);
  }
  
  public static String getSymbol(String major)
  {
    major = major.toLowerCase();
    major = (major.matches("cis|marketing|management|finance|accounting")) 
            ? major : "undeclared";
    if(major.equals("cis"))
      return "CIS";
    else if (major.equals("marketing"))
      return "MKT";
    else if (major.equals("management"))
      return "MGMT";
    else if (major.equals("finance"))
      return "FIN";
    else if (major.equals("accounting"))
      return "ACCT";
    else
      return "UD";
  }
  
  public static boolean updateDB(int index)
  {
    
    return true;
  }
}