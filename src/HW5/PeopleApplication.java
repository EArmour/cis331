/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 5
 * Purpose: 
*/
package HW5;
import javax.swing.*;

public class PeopleApplication {
  public static void main (String args[]) 
  {
    Person.addPerson("Evan", "Armour", 21, "Single", "Male");
    Faculty.addFaculty("Jeff", "MAy", 99, "MarrIED", "MALE", "FULL PROFEssoR");
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
            + " 5: Quit",
            "Person Managment Console!", 3);

      try
      {
        choiceInt = Integer.parseInt(choice);
      }
      catch (Exception e)
      {
        choiceInt = 666;
      }

      if(choiceInt > 5)
        JOptionPane.showMessageDialog(null, "ERROR: Incorrect choice or "
                + "non-integer entered!", "ERROR", 0);

      switch(choiceInt)
      {
        case 1: //addperson
          int age;
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
            age = -1;
          }
          String gender = JOptionPane.showInputDialog(null,  
                  "Please enter the person's gender:", "Input Gender", 3);
          String marital = JOptionPane.showInputDialog(null, "Please enter the "
                  + "person's marital status:", "Input Status", 3);
          
          if(Person.addPerson(fName, lName, age, marital, gender))
            JOptionPane.showMessageDialog(null, "Person successfully added!", 
                    "Success!", 1);
          else
            JOptionPane.showMessageDialog(null, "Maximum amount of persons "
                    + "reached! New person couldn't be added", "ERROR", 0);
          
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
        case 5: //quit
          break;
        default:
            break;
      }
    }while(choiceInt != 5);
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