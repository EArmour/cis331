/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 3
 * Purpose: This assignment makes very sure that you know how to manipulate
 * arrays on many levels, and the value (or danger) of passing by reference.
 * It also further drives home the importance of methods to modulize code, and
 * passing variables between them. With the revised requirements, we also learn
 * the basics of file I/O and checking data integrity before importing it.
*/
package HW3;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class FA13HW3
{
  static int filledRows = 0; //Will be substring of last populated row
  
  public static void main (String args[])
  {
    // [Last Name, First Name]
    String nameArray[][] = new String[100][2];
    // [Age, Weight, IQ]
    int infoArray[][] = new int[100][3];
    
    String chosenDir = initializeArray(nameArray, infoArray);
    if (chosenDir.equals("")) // Error reading data file
      System.exit(0);
    
    checkInput(nameArray, infoArray);
    sort(nameArray, infoArray);
    
    int choiceInt, row;
    String rowString;
    do 
    {
      String choice = JOptionPane.showInputDialog(null, "Choose an option:\n"
            + "1: View All Data\n"
            + "2: View a Single Row\n"
            + "3: Add New Row\n"
            + "4: Update Row\n"
            + "5: Delete Row\n"
            + "6: Search\n"
            + "7: Exit",
            "Array Managment Console!", 3);
      
      choiceInt = tryParse(choice, 666);
      
      switch(choiceInt)
      {
        case 1: //View all
          readEntireArray(nameArray, infoArray);
          break;
        case 2: //View one row
          rowString = JOptionPane.showInputDialog(null, "Which row would"
                  + " you like to display?", "Display Row", 3);
          row = (tryParse(rowString, 667)) - 1 ;
    
          if(row == 666 || row > filledRows)
            JOptionPane.showMessageDialog(null, "Invalid row specified!\nIf you"
                    + " need to find the row of a specific name, use the search"
                    + " function!", "INVALID ROW", 0);
          else
            readOneRow(nameArray, infoArray, row);
          break;
        case 3: //Add row
          create(nameArray, infoArray);
          break;
        case 4: //Update row
          rowString = JOptionPane.showInputDialog(null, "Which row would"
                  + " you like to update?", "Update Row", 3);
          row = (tryParse(rowString, 667)) - 1 ;
    
          if(row == 666 || row > filledRows)
            JOptionPane.showMessageDialog(null, "Invalid row specified!\nIf you"
                    + " need to find the row of a specific name, use the search"
                    + " function!", "INVALID ROW", 0);
          else
            update(nameArray, infoArray, row);
          break;
        case 5: //Delete row
          if(filledRows == 0)
          {
            JOptionPane.showMessageDialog(null, "There's only one row of data!"
                    + "\nYou can't delete the only row!!", "INVALID CHOICE", 0);
          }
          else
          {
            rowString = JOptionPane.showInputDialog(null, "Which row would"
                    + " you like to delete?", "Delete Row", 3);
            row = (tryParse(rowString, 667)) - 1 ;

            if(row == 666 || row > filledRows)
              JOptionPane.showMessageDialog(null, "Invalid row specified!\nIf "
                      + "you need to find the row of a specific name, use the "
                      + "search function!", "INVALID ROW", 0);
            else
              delete(nameArray, infoArray, row);
          }
          break;
        case 6: //Search row
          String find = JOptionPane.showInputDialog(null, "Enter last name of "
                  + "person to find:", "Find Person", 3);
          search(nameArray, infoArray, find);
          break;
        case 7:
          writeData(nameArray, infoArray, chosenDir);
          break;
        default:
          JOptionPane.showMessageDialog(null, "Hey, that's not a valid choice!"
                  + "\nTry again!", "Invalid Choice", 0);
      }
    } while(choiceInt != 7);
  }
  
  public static String initializeArray (String[][] nameArray, int[][] infoArray)
  {
    try
    {
      String dir = JOptionPane.showInputDialog(null, "Please input the "
              + "directory which containts the 'person.txt' data file "
              + "(ex: 'C:/Temp/'):", "Enter Directory", 3);
      File file = new File(dir + "person.txt");
      Scanner input = new Scanner(file);
      int count = 0;

      while (input.hasNext())
      {
        nameArray[count] = new String[]{input.next(),input.next()};
        infoArray[count] = new int[]{input.nextInt(),input.nextInt(),input.nextInt()};
        
        count++;
      }
      input.close();
      filledRows = count - 1;
      return dir;
    }
    catch(Exception e)
    {
      JOptionPane.showMessageDialog(null, "Error loading file: " + e.toString(),
              "Error Initializing Data!", 0);
    }
    return "";
  }
  
  public static void checkInput (String[][] nameArray, int [][] infoArray)
  {
    int errorcount = 0;
    for(int i=0;i<filledRows + 1;i++)
    {
      for(int j=0; j<nameArray[i].length;j++)
      {
        if (nameArray[i][j].length() > 10)
        {
          errorcount++;
          String correction = JOptionPane.showInputDialog(null, "String value " 
                  + nameArray[i][j] + " is invalid!\nNames must be no more than"
                  + " 10 characters long. Enter a valid name:", "Bad Input", 0);
          nameArray[i][j] = correction;
        }
      }
      for(int k=0; k<infoArray[i].length; k++)
      {
        if (k == 0 && (infoArray[i][k] < 0 || infoArray[i][k] > 120)) //Age
        {
          errorcount++;
          String correction = JOptionPane.showInputDialog(null, "Integer value " 
                  + infoArray[i][k] + " is invalid!\nAges must be between 0 and"
                  + " 120. Enter a valid age:", "Bad Input", 0);
          int corrInt = tryParse(correction, 666);
          infoArray[i][k] = corrInt;
        }
        else if (k == 1 && (infoArray[i][k] < 10 || infoArray[i][k] > 500)) //Wt
        {
          errorcount++;
          String correction = JOptionPane.showInputDialog(null, "Integer value " 
                  + infoArray[i][k] + " is invalid!\nWeights must be between 10"
                  + " and 500. Enter a valid weight:", "Bad Input", 0);
          int corrInt = tryParse(correction, 666);
          infoArray[i][k] = corrInt;
        }
        else if (k == 2 && (infoArray[i][k] < 60 || infoArray[i][k] > 200)) //IQ
        {
          errorcount++;
          String correction = JOptionPane.showInputDialog(null, "Integer value " 
                  + infoArray[i][k] + " is invalid!\nIQs must be between 60 "
                  + "and 200. Enter a valid IQ:", "Bad Input", 0);
          int corrInt = tryParse(correction, 666);
          infoArray[i][k] = corrInt;
        }
      }
    }
    if(errorcount > 0)
    {
      JOptionPane.showMessageDialog(null, "You had " + errorcount + " errors in"
              + " your input file!\nHopefully you've corrected them all.", 
              "Error Count", 1);
      checkInput(nameArray, infoArray); // Make sure corrections are valid
    }
  }
  
  public static void readEntireArray (String[][] nameArray, int[][] infoArray)
  {
    JTextArea areaOutput = new JTextArea();
    String output = header();
    
    for(int i=0;i<filledRows + 1;i++)
    {
      for(int j=0; j<nameArray[i].length;j++)
        output += nameArray[i][j] + "\t";
      
      for(int k=0; k<infoArray[i].length; k++)
      {        
        output += infoArray[i][k] + "\t";
        
        if(k == 2) // IQ, means end of row of data
          output += "\n";
      }
    }
    areaOutput.setText(output);
    JOptionPane.showMessageDialog(null, areaOutput, "Output!", 1);
  }
  
  public static void readOneRow (String[][] nameArray, int[][] infoArray, 
          int row)
  {
    JTextArea outputArea = new JTextArea();
    String output = header();
    
    for(int j=0; j<nameArray[row].length;j++)
      output += nameArray[row][j] + "\t";

    for(int k=0; k<infoArray[row].length; k++)
      output += infoArray[row][k] + "\t";
    
    outputArea.setText(output);
    JOptionPane.showMessageDialog(null, outputArea, "Results for Row #" + 
            (row + 1), 1);
  }
  
  public static void create (String[][] nameArray, int[][] infoArray)
  {
    String fName = JOptionPane.showInputDialog(null, "Please enter the person's"
            + " first name (10 character max!):", "Adding Information", 3);
    
    String lName = JOptionPane.showInputDialog(null, "Please enter the person's"
            + " last name (10 character max!):", "Adding Information", 3);
    
    String ageString = JOptionPane.showInputDialog(null, "Please enter the"
            + " person's age:", "Adding Information", 3);
    int age = tryParse(ageString, 9999);
    
    String weightString = JOptionPane.showInputDialog(null, "Please enter the"
            + " person's weight:", "Adding Information", 3);
    int weight = tryParse(weightString, 9999);
    
    String iqString = JOptionPane.showInputDialog(null, "Please enter the"
            + " person's IQ:", "Adding Information", 3);
    int iq = tryParse(iqString, 9999);
    
    if(fName.length() > 10 || lName.length() > 10 || age > 999 || weight > 999
            || iq > 999)
      JOptionPane.showMessageDialog(null, "That's not valid information, dude!"
              + "\nStart again, and take it seriously now!", "INVALID DATA", 0);
    else
    {
      nameArray[filledRows + 1] = new String[]{lName,fName};
      infoArray[filledRows + 1] = new int[]{age, weight, iq};
      JOptionPane.showMessageDialog(null, "A row for " + lName + " has been "
              + "created in the array!", "Row Added!", 1);
      sort(nameArray, infoArray);
    }
  }
  
  public static void update (String[][] nameArray, int[][] infoArray, int row)
  {
    String update = JOptionPane.showInputDialog(null, "The current last "
            + "name is " + nameArray[row][0] + ".\nWhat would you like to"
            + " change it to?", "Update Row", 3);
    if(update.length() > 10 || update.length() < 1)
    {
      JOptionPane.showMessageDialog(null, "Invalid name specified!\nNames "
              + "cannot exceed 10 characters in length!", "INVALID NAME", 0);
      update(nameArray, infoArray, row);
    }
              
    else
    {
      nameArray[row][0] = update;
      readOneRow(nameArray, infoArray, row);
      sort(nameArray, infoArray);
    }
  }
 
  public static void delete (String[][] nameArray, int[][] infoArray, int row)
  {
    nameArray[row] = new String[]{null,null};
    infoArray[row] = new int[]{0,0,0};
    JOptionPane.showMessageDialog(null, "Row #" + (row + 1) + " was deleted!"
            + "\nI really hope you meant to do that!", "Row Deleted!", 1);
    sort(nameArray, infoArray);
  }
  
  public static void search (String[][] nameArray, int[][] infoArray, 
          String find)
  {
    int subscript = -1234;
    for(int i=0; i<filledRows + 1; i++)
    {
      if(nameArray[i][0] == null) // Can't use equalsIgnoreCase on NULL
        break;
      else if(nameArray[i][0].equalsIgnoreCase(find))
      {
        subscript = i;
        break;
      }
    }
    if (subscript == -1234)
      JOptionPane.showMessageDialog(null, "No result found for last name '" + 
            find + "' in any row!", "No Row Found", 0);
    else
      JOptionPane.showMessageDialog(null, "The first person with last name '" + 
            find + "' is at row number " + (subscript + 1), "Row Found", 1);
  }
  
  public static void sort (String[][] nameArray, int[][] infoArray)
  {
    for(int r=0; r < (filledRows*filledRows)+1; r++) //Account for max disorder
    {
      for(int i=0; i < nameArray.length - 1; i++)
      {
        if(nameArray[i][0] == null && nameArray[i + 1][0] == null)
        {
          /* Two nulls sequentially means the end of data-filled rows, since we
           * sort after every operation, and no operation modifies more than one
           * row at a time, there can never be two null-filled rows unless
           * they were never used for anything. Thus we can determine how many
           * rows are actually utilized.
           */
          filledRows = i - 1;
          break;
        }
        else if(nameArray[i][0] == null)
        {
          // No need to store temps, since the other row will end up being null
          nameArray[i] = nameArray[i+1];
          infoArray[i] = infoArray[i+1];
          nameArray[i+1] = new String[]{null, null};
          infoArray[i+1] = new int[]{0,0,0};
        }
        else if(nameArray[i + 1][0] == null)
          continue; //Skip
        else
        {
          int compare = nameArray[i][0].compareToIgnoreCase(nameArray[i+1][0]);
          if(compare > 0) //Current row is alphabetically after next row
          {
            String[] tempName = nameArray[i];
            int[] tempInfo = infoArray[i];
            nameArray[i] = nameArray[i+1];
            infoArray[i] = infoArray[i+1];
            nameArray[i+1] = tempName;
            infoArray[i+1] = tempInfo;
          }
          else
            continue;
        }
      }
    }
  }
  
  public static void writeData (String[][] nameArray, int[][] infoArray, 
          String dir)
  {
    try
    {
      File outputFile = new File(dir + "personOutput.txt");
      FileWriter output = new FileWriter(outputFile);

      for(int i=0;i<filledRows + 1;i++)
      {
        for(int j=0; j<nameArray[i].length;j++)
          output.write(nameArray[i][j] + " ");

        for(int k=0; k<infoArray[i].length; k++)
        {        
          output.write(infoArray[i][k] + " ");

          if(k == 2) // IQ, means end of row of data
            output.write("\n");
        }
      }
      output.close();
      
      JOptionPane.showMessageDialog(null, "Updated data successfully saved to "
              + dir + "personOutput.txt", "Data Saved", 1);
    }
    catch(Exception e)
    {
      JOptionPane.showMessageDialog(null, "Sorry, there was an error saving "
              + "your data!\n" + e.toString(), "Error!", 0);
    }
  }
  
  public static int tryParse (String input, int fallback)
  {
    int result;
    try
    {
      result = Integer.parseInt(input);
    }
    catch(NumberFormatException e)
    {
      result = fallback;
    }
    return result;
  }
  
  public static String header ()
  {
    // This is a very silly method
    return "Last Name\tFirst Name\tAge\tWeight\tIQ\n"
            + "+++++++++\t+++++++++\t+++++++++\t+++++++++\t+++++++++\n";
  }
}