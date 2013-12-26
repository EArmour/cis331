/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 6
*/
package HW6;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Person 
{
  private String firstName;
  private String lastName;
  private int age;
  private String maritalStatus;
  private String gender;
  
  protected static int totPeople = 0;
  protected static final int MAXPEOPLE = 10;
  protected static Person[] people = new Person[MAXPEOPLE];

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
    this.age = (age < 1) ? 0 : age;
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
  
  public String toString()
  {
    return this.getfirstName() + " " + this.getlastName();
  }
  
  public static void readPeople()
  {
    //Reset person count to overwrite any existing data
    totPeople = 0;
    
    try
    {
      File file = new File("C:/Temp/people.txt");
      Scanner input = new Scanner(file);

      while (input.hasNext())
      {
        if(addPerson(input.next(), input.next(), input.nextInt(), input.next(), 
                input.next()))
          continue;
        else {
          JOptionPane.showMessageDialog(null, "Maximum number of people "
                  + "reached!\nNot all people from the file could be added",
                  "Error Initializing Data!", 0);
          break;
        }  
      }
      input.close();
    }
    catch(Exception e) {
      JOptionPane.showMessageDialog(null, "Error loading file: " + e.toString(),
              "Error Initializing Data!", 0);
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
  
  //Capitalize only first letter for nice-looking text
  public String toPrettyText(String ugly) {
    return ugly.substring(0,1).toUpperCase() + ugly.substring(1).toLowerCase();
  }
}