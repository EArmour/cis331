// Example 4 - Compute the sum of the elements of the array
import javax.swing.*;

public class Ex4SumArray 
{
   public static void main( String args[] )
   {
      int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
      int sum = 0;

      for ( int i = 0; i < a.length; i++ ) 
         sum += a[ i ];

      JOptionPane.showMessageDialog( null, "Sum of array elements: " + sum,
         "Sum the Elements of an Array", JOptionPane.INFORMATION_MESSAGE );
   }
}