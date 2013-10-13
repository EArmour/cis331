// Simple For Loop
import javax.swing.JOptionPane;

public class EX4ForLoop
{
   public static void main( String args[] )
   {
      int sum = 0;

      for ( int number = 2; number <= 100; number += 2 )
         sum += number;

      JOptionPane.showMessageDialog( null, 
         "The sum is " + sum,
         "Sum Even Integers from 2 to 100",
         JOptionPane.INFORMATION_MESSAGE );
   }
}