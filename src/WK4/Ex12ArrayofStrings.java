// Example 7 - Passing arrays and individual array elements to methods
import javax.swing.*;

public class Ex12ArrayofStrings
{
   public static void main( String args[] )
   {
      String a[] = {"hello", "goodbye"};
     
      JTextArea outputArea = new JTextArea();
      String output = "Effects of passing entire " +
               "array reference:\n\n" +
               "The Strings of the original array are:\n";
      
      for ( int i = 0; i < a.length; i++ )
         output += "   " + a[ i ];
   
      modifyArray( a );
   
      output += "\n\nThe Strings of the modified array are:\n";

      for ( int i = 0; i < a.length; i++ ) 
         output += "   " + a[ i ];
   
      outputArea.setText( output );
      
      JOptionPane.showMessageDialog( null, outputArea,
         "Passing Arrays",
         JOptionPane.INFORMATION_MESSAGE );
   }
   
   public static void modifyArray( String b[] )
   {
     String temp = "";
     temp = b[0];
     b[0] = b[1];
     b[1] = temp;
   }
     
}


