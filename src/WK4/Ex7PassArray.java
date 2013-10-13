// Example 7 - Passing arrays and individual array elements to methods
import javax.swing.*;

public class Ex7PassArray
{
   public static void main( String args[] )
   {
      JTextArea outputArea = new JTextArea();
      String output = "Effects of passing entire " +
               "array:\n" +
               "The values of the original array are:\n";
      int a[] = { 1, 2, 3, 4, 5 };

      for ( int i = 0; i < a.length; i++ )
         output += "   " + a[ i ];
   
      modifyArray( a );  // pass a reference
   
      output += "\n\nThe values of the modified array are:\n";

      for ( int i = 0; i < a.length; i++ ) 
         output += "   " + a[ i ];
   
      output += "\n\nEffects of passing array element value:\n" +
                "a[3] before modifyElement: " + a[ 3 ];
   
      modifyElement( a[ 3 ] );
   
      output += "\na[3] after modifyElement: " + a[ 3 ];
      outputArea.setText( output );
      
      JOptionPane.showMessageDialog( null, outputArea,
         "Passing Arrays",
         JOptionPane.INFORMATION_MESSAGE );
   }
   
   public static void modifyArray( int b[] ) //pass a reference
   {
      for ( int j = 0; j < b.length; j++ )
         b[ j ] *= 2;
   }
   
   public static void modifyElement( int e ) //pass a value
   {
      e *= 2;
   }   
}


