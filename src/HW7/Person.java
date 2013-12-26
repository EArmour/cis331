/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 7
*/
package HW7;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.*;
import java.sql.*;

public class Person 
{
  private String firstName;
  private String lastName;
  private int age;
  private String maritalStatus;
  private String gender;
  
  protected static int totPeople = 0;
  protected static final int MAXPEOPLE = 100;
  protected static Person[] people = new Person[MAXPEOPLE];
  protected static Connection connection;

  public Person() 
  {
    this.firstName = "FIRST";
    this.lastName = "LAST";
    this.age = 0;
    this.maritalStatus = "Unknown";
    this.gender = "Unknown";
  }

  public Person(String firstName, String lastName, int age, 
          String maritalStatus, String gender) 
  {
    this.setfirstName(firstName);
    this.setlastName(lastName);
    this.setAge(age);
    this.setMaritalStatus(maritalStatus);
    this.setGender(gender);
  }
  
  public static boolean addPerson(String firstName, String lastName, int age, 
          String maritalStatus, String gender) 
  {
    if (totPeople == MAXPEOPLE)
      return false;
    
    people[totPeople] = new Person(firstName, lastName, age, 
            maritalStatus, gender);
    totPeople++;
    return true;
  }
  
  public String getfirstName() {
    return firstName;
  }

  public void setfirstName(String firstName) {
    this.firstName = toPrettyText(firstName);
  }

  public String getlastName() {
    return lastName;
  }

  public void setlastName(String lastName) {
    this.lastName = toPrettyText(lastName);
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = (age < 1 || age > 100) ? 0 : age;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    maritalStatus = toPrettyText(maritalStatus);
    
    if(maritalStatus.matches("Married|Divorced|Widowed|Single"))
      this.maritalStatus = maritalStatus;
    else
      this.maritalStatus = "Unknown";
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    gender = toPrettyText(gender);
    
    if(gender.matches("Male|Female"))
      this.gender = gender;
    else
      this.gender = "Unknown";
  }
  
  public static int getTotPeople()
  {
    return totPeople;
  }
  
  public static Person getPerson(int index)
  {
    return people[index];
  }
  
  public String personInfo(boolean fullData)
  {
    String info = "First: " + this.firstName + "\tLast: " + this.lastName;
    if (fullData)
      info += "\tAge: " + this.age + "\tGender: " + this.gender + 
              "\tMarital Status: " + this.maritalStatus;
    return info;
  }
  
  public static double averageAge()
  {
    double avg = 0D;
    for (int i=0; i<totPeople; i++)
    {
      avg += people[i].getAge();
    }
    return (Double) avg / totPeople; 
  }
  
  public boolean equals(String testString)
  {
    if(testString.equalsIgnoreCase(this.firstName + " " + this.lastName))
      return true;
    else
      return false;
  }
  
  public static String listPersons()
  {
    String names = "";
    
    for (int i=0; i<totPeople; i++)
    {
      names += "\n" + (i+1) + ". " + people[i].getfirstName() + " " + 
              people[i].getlastName() + " (" + people[i].toString() + ")";
    }
    
    return names;
  }
  
  public static int findPerson(String searchString)
  {
    int index = -1;
    
    for (int i=0; i<totPeople; i++)
    {
      if (people[i].equals(searchString))
      {
        index = i;
        break;
      }
    }
    return index;
  }
  
  public static boolean readPeople()
  {
    //Reset person count to overwrite any existing data
    totPeople = 0;
    Faculty.totFaculty = 0;
    Student.totStudents = 0;

    try
    {
      File file = new File("C:/Temp/people.txt");
      Scanner input = new Scanner(file);

      while (input.hasNextLine())
      {
        StringTokenizer line = new StringTokenizer(input.nextLine());
        int args = line.countTokens();
        
        String fName = line.nextToken();
        String lName = line.nextToken();
        int age = Integer.parseInt(line.nextToken());
        String mStatus = line.nextToken();
        String gender = line.nextToken();
        String rankS;
        
        switch(args)
        {
          case 5: //Generic person
            if(addPerson(fName, lName, age, mStatus, gender)) 
              continue;
            else {
              JOptionPane.showMessageDialog(null, "Maximum number of people "
                      + "reached!\nNot all people from the file could be added",
                      "Error Initializing Data!", 0);
            }
            break;
          case 6: //Faculty with one-word rank
            rankS = Faculty.getSymbol(line.nextToken());
            if(Faculty.addFaculty(fName, lName, age, mStatus, gender, rankS)) 
              continue;
            else {
              JOptionPane.showMessageDialog(null, "Maximum number of people "
                      + "reached!\nNot all people from the file could be added",
                      "Error Initializing Data!", 0);
            }
            break;
          case 7: //Faculty with two-word rank
            rankS = Faculty.getSymbol(line.nextToken() + " " + line.nextToken());
            if(Faculty.addFaculty(fName, lName, age, mStatus, gender, rankS))
              continue;
            else {
              JOptionPane.showMessageDialog(null, "Maximum number of people "
                      + "reached!\nNot all people from the file could be added",
                      "Error Initializing Data!", 0);
            }
            break;
          case 8: //Student
            String majorS = Student.getSymbol(line.nextToken());
            String standing = line.nextToken();
            Double GPA = Double.parseDouble(line.nextToken());
            if(Student.addStudent(fName, lName, age, mStatus, gender, majorS, 
                    standing, GPA))
              continue;
            else {
              JOptionPane.showMessageDialog(null, "Maximum number of people "
                      + "reached!\nNot all people from the file could be added",
                      "Error Initializing Data!", 0);
            }
            break;
        }
      }
      input.close();
      return true;
    }
    catch(Exception e) {
      JOptionPane.showMessageDialog(null, "Error loading file: " + e.toString(),
              "Error Initializing Data!", 0);
      return false;
    }
  }
  
  public static void writePeople()
  {
    try
    {
      File file = new File("C:/Temp/peopleOutput.txt");
      FileWriter output = new FileWriter(file);

      for(int i=0; i<totPeople; i++)
      {
        Person curr = people[i];
        output.write(curr.getfirstName() + "\t" + curr.getlastName() + "\t" + 
                curr.getAge() + "\t" + curr.getMaritalStatus() + "\t" + 
                curr.getGender() + "\n");
      }
      output.close();
    }
    catch(Exception e) {
      JOptionPane.showMessageDialog(null, "Error writing file: " + e.toString(),
              "Error Saving Data!", 0);
    }
  }
  
  public String toString()
  {
    return this.getfirstName() + " " + this.getlastName();
  }
  
  //Capitalize only first letter for nice-looking text
  public String toPrettyText(String ugly) {
    return ugly.substring(0,1).toUpperCase() + ugly.substring(1).toLowerCase();
  }
  
  public static void connect() 
  {
    String dataSource = "HW7";
    String userID = "";
    String password = "";
    try
    {
        Connection con = null;
        String url = "jdbc:odbc:" + dataSource;
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection(url,userID,password);
        connection = con;
    }
    catch(Exception e)
    {
      JOptionPane.showMessageDialog(null, e.toString());
        connection=null;
    }
  }

  public static boolean isConnected() 
  {
    boolean ret = false;
    try 
    {
      if(null == connection || connection.isClosed())
        ret = false;
      else
        ret = true;
    }
    catch(SQLException e) {
      e.printStackTrace();
      ret = false;
    }
    return ret;
  }
  
  public static boolean clearDB()
  {
    if (!isConnected())
      connect();
    
    try
    {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate("DELETE * FROM Person");
      stmt.executeUpdate("DELETE * FROM Student");
      stmt.executeUpdate("DELETE * FROM Faculty");
      stmt.executeUpdate("DELETE * FROM Rank");
      stmt.executeUpdate("DELETE * FROM Major");

      connection.close();
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
    
    return true;
   }
  
  public static boolean loadDB()
  {
    if (totPeople == 0){
      return false;}
    if (!isConnected())
      connect();

    try
    {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate("INSERT INTO RANK VALUES('AP','Assistant Professor')");
      stmt.executeUpdate("INSERT INTO RANK VALUES('FP','Full Professor')");
      stmt.executeUpdate("INSERT INTO RANK VALUES('I','Instructor')");
      stmt.executeUpdate("INSERT INTO MAJOR VALUES('UD','Undecided')");
      stmt.executeUpdate("INSERT INTO MAJOR VALUES('CIS','Computer Info Systems')");
      stmt.executeUpdate("INSERT INTO MAJOR VALUES('MKTG','Marketing')");
      stmt.executeUpdate("INSERT INTO MAJOR VALUES('MGMT','Management')");
      stmt.executeUpdate("INSERT INTO MAJOR VALUES('ACCT','Accounting')");
      stmt.executeUpdate("INSERT INTO MAJOR VALUES('FIN','Finance')");
      
      for(int i=0;i<totPeople;i++)
      {
        stmt.executeUpdate("INSERT INTO PERSON VALUES('" + 
                i + "','" +
                people[i].firstName + "','" +
                people[i].lastName + "','" +
                people[i].age + "','" +
                people[i].maritalStatus + "','" +
                people[i].gender + "')");
        if(isFaculty(i))
        {
          Faculty fac = (Faculty) people[i];
          stmt.executeUpdate("INSERT INTO FACULTY VALUES('" +
                  i + "','" +
                  fac.getRank() + "')");
        }
        else if(isStudent(i))
        {
          Student stu = (Student) people[i];
          stmt.executeUpdate("INSERT INTO STUDENT VALUES('" +
                  i + "','" +
                  stu.getMajor() + "','" +
                  stu.getClassStanding() + "','" +
                  stu.getGPA() + "')");
        }
        
      }

    }
    catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }

    return true;
  }
  
  private static boolean isFaculty(int index)
  {
    for(int i=0;i<Faculty.totFaculty;i++)
    {
      if(Faculty.faculty[i] == 0 && Faculty.faculty[i+1] == 0) //End of real data
        return false;
      else if(Faculty.faculty[i] == index)
        return true;
    }
    return false;
  }
  
  private static boolean isStudent(int index)
  {
    for(int i=0;i<Student.totStudents;i++)
    {
      if(Student.students[i] == 0 && Student.students[i+1] == 0) //End of real data
        return false;
      else if(Student.students[i] == index)
        return true;
    }
    return false;
  }
  
  public static String[] query(int index)
  {
    if (!isConnected())
      connect();
    
    try
    {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM PERSON WHERE PersonNum = " + index);
      rs.next();
      String fName = rs.getString(2);
      String lName = rs.getString(3);
      String age = rs.getString(4);
      String mStatus = rs.getString(5);
      String gender = rs.getString(6);
      
      rs = stmt.executeQuery("SELECT Rank FROM Rank WHERE RankSymbol = (SELECT RankSymbol FROM Faculty WHERE PersonNum = " + index + ")");
      rs.next();
      String rank = rs.getString(1);
      
      String[] result = new String[] {fName, lName, age, mStatus, gender, rank};
      
      return result;
    }
    catch(SQLException s)
    {
      
      JOptionPane.showMessageDialog(null, s.toString());
    }
    return new String[] {""};
  }
  
  public static boolean updateDB(int index)
  {
    if (!isConnected())
      connect();
    
    try
    {
      Person person = people[index];
      
      Statement stmt = connection.createStatement();
      stmt.executeUpdate("UPDATE PERSON SET " + 
              "FirstName = '" + person.firstName + "'," +
              "LastName = '" + person.lastName + "'," +
              "Age = " + person.age + "," +
              "MaritalStatus = '" + person.maritalStatus + "'," +
              "Gender = '" + person.gender + 
              "' WHERE PersonNum  = " + index + ";");
      if(isFaculty(index))
      {
        Faculty fac = (Faculty) people[index];
        stmt.executeUpdate("UPDATE FACULTY SET " +
                "RankSymbol = '" + fac.getSymbol(fac.getRank()) +
                "' WHERE PersonNum  = " + index + ";");
      }
      else if(isStudent(index))
      {
        Student stu = (Student) people[index];
        stmt.executeUpdate("UPDATE STUDENT SET " +
                "MajorSymbol = '" + stu.getSymbol(stu.getMajor()) + "'," +
                "ClassStanding = '" + stu.getClassStanding() + "'," +
                "GPA = " + stu.getGPA() + " WHERE PersonNum = " + index + ";");
      }
      return true;
    }
    catch(SQLException s)
    {
      JOptionPane.showMessageDialog(null, s.toString());
      return false;
    }
  }
}