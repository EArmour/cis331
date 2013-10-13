// Example 3 - Initialize array n to the even integers from 2 to 20
import javax.swing.*;

public class Ex3InitArray3 
{
   public static void main( String args[] )
   {
      final int ARRAY_SIZE = 10; //constants are good WHY???
      int n[];                    // reference to int array
      String output = "";

      n = new int[ ARRAY_SIZE ];  // allocate array

      // Set the values in the array
      for ( int i = 0; i < n.length; i++ ) 
         n[ i ] = 2 + 2 * i;

      output += "Subscript\tValue\n";
   
      for ( int i = 0; i < n.length; i++ ) 
         output += i + "\t" + n[ i ] + "\n";

      JTextArea outputArea = new JTextArea( 11, 10 );
      outputArea.setText( output );

      JOptionPane.showMessageDialog( null, outputArea,
         "Initializing to Even Numbers from 2 to 20",
         JOptionPane.INFORMATION_MESSAGE );
   }
}
