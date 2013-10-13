// Sorting String Arrays Help

import javax.swing.*;
public class StringSortHelp
{
  public static void main( String args[] )
  {
    String a[][] = new String[10][2];
    
    a[0][0] = "apple";    
    a[0][1] = "banannas";
    a[1][0] = "cat";    
    a[1][1] = "rainman";
    
// Change the values of the subscript and read the comment below
    int num = a[0][0].compareToIgnoreCase(a[0][1]);
    
    JOptionPane.showMessageDialog( null, num, "Get it?",
            JOptionPane.INFORMATION_MESSAGE );
    
    int i = 0;
    for(i = 0; i < a.length; i++)
      if(a[i][0] == null)
        break;
            
    JOptionPane.showMessageDialog( null, i, "Get it?",
            JOptionPane.INFORMATION_MESSAGE );
    
    for (int j = 0; j < a.length; j++)
      if(a[j][0] != null)
        printRow(a[j]);
    
    switchRow(a); //Oh Yeah!
    
    for (int j = 0; j < a.length; j++)
      if(a[j][0] != null)
        printRow(a[j]);
  }
  public static void printRow( String a[] )
  {
    String output = "";

    for ( int j = 0; j < a.length; j++ )  
      output += a[ j ] + "  ";

    JOptionPane.showMessageDialog( null, output,
       "Row Values for Row", JOptionPane.INFORMATION_MESSAGE );
  }
  
  //swaps the addresses of the first two rows
  public static void switchRow( String a[][] ) 
  {
    String temp [] = a[0]; 
    a[0] = a[1];
    a[1] = temp;
  }
}

