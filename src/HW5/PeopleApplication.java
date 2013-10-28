/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 5
 * Purpose: This assignment elaborates on HW4, and introduces sophisticated
 * subclasses. Particularly emphasized is method overriding and dynamic binding.
*/
package HW5;
import javax.swing.*;

public class PeopleApplication {
  public static void main (String args[]) 
  {
    menuChoice();
  }

  public static void menuChoice()
  {
    int choiceInt = 666;
    
    do
    {
      String choice = JOptionPane.showInputDialog(null, "Choose an option:\n"
            + " 1: Add New Person\n"
            + " 2: Display All Names\n"
            + " 3: Get Person Info\n"
            + " 4: Display Average Age\n"
            + " 5: Display Average Student GPA\n"
            + " 6: Quit",
            "Person Managment Console!", 3);

      try
      {
        choiceInt = Integer.parseInt(choice);
      }
      catch (Exception e)
      {
        choiceInt = 666;
      }

      if(choiceInt > 6)
        JOptionPane.showMessageDialog(null, "ERROR: Incorrect choice or "
                + "non-integer entered!", "ERROR", 0);

      switch(choiceInt)
      {
        case 1: //addperson
          int age;
          String type = JOptionPane.showInputDialog(null, "Is this a Faculty or"
                  + " Student?\nLeave blank for default Person.", "Type", 3);
          String fName = JOptionPane.showInputDialog(null, 
                  "Please enter the person's first name:", "Input Name", 3);
          String lName = JOptionPane.showInputDialog(null,  
                  "Please enter the person's last name:", "Input Name", 3);
          String ageString = JOptionPane.showInputDialog(null,  
                  "Please enter the person's age:", "Input Age", 3);
          try
          {
            age = Integer.parseInt(ageString);
          }
          catch (Exception e)
          {
            age = 0;
          }
          String gender = JOptionPane.showInputDialog(null,  
                  "Please enter the person's gender:", "Input Gender", 3);
          String marital = JOptionPane.showInputDialog(null, "Please enter the "
                  + "person's marital status:", "Input Status", 3);
          if(type.toLowerCase().startsWith("f")) //Faculty
          {
            String rank = JOptionPane.showInputDialog(null, 
                    "Please enter the faculty's rank:", "Input Rank", 3);
            if(Faculty.addFaculty(fName, lName, age, marital, gender, rank))
              JOptionPane.showMessageDialog(null, "Faculty successfully added!", 
                      "Success!", 1);
            else
              JOptionPane.showMessageDialog(null, "Maximum amount of persons "
                      + "reached! New Faculty couldn't be added", "ERROR", 0); 
          }
          else if (type.toLowerCase().startsWith("s")) //Student
          {
            double GPA;
            String major = JOptionPane.showInputDialog(null, 
                    "Please enter the student's major:", "Input Major", 3);
            String standing = JOptionPane.showInputDialog(null, 
                    "Please enter the student's standing:", "Input Standing", 3);
            String GPAString = JOptionPane.showInputDialog(null, 
                    "Please enter the student's GPA:", "Input GPA", 3);
            try 
            {
             GPA = Double.parseDouble(GPAString);
            } 
            catch (Exception e) 
            {
              GPA = 0.0;
            }
            if(Student.addStudent(fName, lName, age, marital, gender, major, 
                    standing, GPA))
              JOptionPane.showMessageDialog(null, "Student  successfully added!", 
                      "Success!", 1);
            else
              JOptionPane.showMessageDialog(null, "Maximum amount of persons "
                      + "reached! New Student couldn't be added", "ERROR", 0); 
          }
          else //Person
          {
            if(Person.addPerson(fName, lName, age, marital, gender))
              JOptionPane.showMessageDialog(null, "Person successfully added!", 
                      "Success!", 1);
            else
              JOptionPane.showMessageDialog(null, "Maximum amount of persons "
                      + "reached! New person couldn't be added", "ERROR", 0); 
          }
          
          break;
        case 2: //displaynames
          if(!noPeople())
          {
            JOptionPane.showMessageDialog(null, "All persons:\n" + 
                    Person.listPersons(), "List of Persons", 1);
          }
          break;
        case 3: //getinfo
          if(!noPeople())
          {
            String find = JOptionPane.showInputDialog(null, "Please enter the "
                    + "full name of the person you wish to find "
                    + "(ex: 'John Smith'):", "Find Person", 3);
            int index = Person.findPerson(find);
            if (index == -1)
              JOptionPane.showMessageDialog(null, "No person with that name was"
                      + " found!", "ERROR", 0);
            else
            {
              Person foundPerson = Person.getPerson(index);
              JOptionPane.showMessageDialog(null, new JTextArea
                      (foundPerson.personInfo(true)), "Person Info", 3);
            }
          }
          break;
        case 4: //averageage
          if(!noPeople())
          {
          JOptionPane.showMessageDialog(null, "Average age of all persons is: " 
                  + Person.averageAge(), "Average Age", 1);
          }
          break;
        case 5: //averagegpa
          if(!noPeople())
            JOptionPane.showMessageDialog(null, Student.showOverallGPA(), 
                    "Average GPA", 1);
          break;
        case 6: //quit
          break;
        default:
            break;
      }
    }while(choiceInt != 6);
  }
  
  // Test if there are no Persons instantiated before trying to get their info
  public static boolean noPeople()
  {
    if(Person.getTotPeople() == 0)
    {
      JOptionPane.showMessageDialog(null, "There are no people to get"
              + " information from!", "ERROR", 0);
      return true; 
    }
    
    return false;
  }
}