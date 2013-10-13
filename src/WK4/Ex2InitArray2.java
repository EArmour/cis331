// Example 2 - Initializing an array with a declaration
import javax.swing.*;

public class Ex2InitArray2 
{
   public static void main( String args[] )
   {
      String output = "";

      // Initializer list specifies number of elements and
      // value for each element.
      int n[] = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };

      output += "Subscript\tValue\n";
   
      for ( int i = 0; i < n.length; i++ ) 
         output += i + "\t" + n[ i ] + "\n";

      JTextArea outputArea = new JTextArea( 11, 10 );
      outputArea.setText( output );

      JOptionPane.showMessageDialog( null, outputArea,
         "Initializing an Array with a Declaration",
         JOptionPane.INFORMATION_MESSAGE );
   }
}