// Example 1 - Initializing an array
import javax.swing.*;

public class Ex1InitArray
{
   public static void main( String args[] )
   {
      String output = "";
      int n[];            // declare reference to an array
      int num = 10;
      n = new int[ 10 ];  // dynamically allocate array

      output += "Subscript\tValue\n";
   
      for ( int i = 0; i < n.length; i++ )
      {
        n[i] += num++ * i;
        output += i + "\t" + n[ i ] + "\n";
      }
         

      JTextArea outputArea = new JTextArea( 11, 10 );
      outputArea.setText( output );

      JOptionPane.showMessageDialog( null, outputArea,
         "Initializing an Array of int Values",
         JOptionPane.INFORMATION_MESSAGE );
   }
}
