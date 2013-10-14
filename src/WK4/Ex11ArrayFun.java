// Example 11 - 2D Array FUN!

import javax.swing.*;

public class Ex11ArrayFun
{
   public static void main( String args[] )
   {
      int grades[][] = { { 77, 68, 86, 73 }, 
                      { 96, 87, 89, 81 },
                      { 70, 90, 86, 81 } };
      int students = grades.length, exams = grades[ 0 ].length;
      JTextArea outputArea = new JTextArea();

      String output = "The array is:\n\n";
      output += "                     ";

      for ( int i = 0; i < exams; i++ ) 
         output += "[" + i + "]   ";

      for ( int i = 0; i < students; i++ ) 
      {
         output += "\ngrades[" + i + "]   ";
         for ( int j = 0; j < exams; j++ ) 
            output += grades[ i ][ j ] + "   ";
      }
      output += "\n\nLowest grade: " + minimum(grades) +
                "\nHighest grade: " + maximum(grades) + "\n";

      for ( int i = 0; i < students; i++ ) 
         output += "\nAverage for student " + i + " is " +
                   average( grades[ i ] );

      outputArea.setText( output );
      JOptionPane.showMessageDialog( null, output,
         "2D Array Fun", JOptionPane.INFORMATION_MESSAGE );
   }

   // find the minimum grade
   public static int minimum(int a[][])
   { 
      int lowGrade = 100;

      for ( int i = 0; i < a.length; i++ ) 
         for ( int j = 0; j < a[i].length; j++ ) 
            if ( a[ i ][ j ] < lowGrade )
               lowGrade = a[ i ][ j ];

      return lowGrade;
   }

   // find the maximum grade
   public static int maximum(int a[][])
   { 
      int highGrade = 0;

      for ( int i = 0; i < a.length; i++ ) 
         for ( int j = 0; j < a[i].length; j++ ) 
            if ( a[ i ][ j ] > highGrade )
               highGrade = a[ i ][ j ];

      return highGrade;
   }

   // determine the average grade for a particular
   // student (or set of grades)
   public static double average( int setOfGrades[] )
   {
      int total = 0;
 
      for ( int i = 0; i < setOfGrades.length; i++ )
         total += setOfGrades[ i ];

      return ( double ) total / setOfGrades.length;
   }
}

   

