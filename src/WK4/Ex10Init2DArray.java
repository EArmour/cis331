// Example 10 - Init and print 2D Array
import javax.swing.*;

public class Ex10Init2DArray
{
   public static void main( String args[] )
   {
      int array1[][] = { { 1, 2, 3 }, { 4, 5, 6 } };        
      int array2[][] = { { 1, 2 }, { 3 }, { 4, 5, 6 } }; 

      printArray( array1 );
      printArray( array2 );
   }

   public static void printArray( int a[][] )
   {
     String output = "";
     for ( int i = 0; i < a.length; i++ )
     {
         for ( int j = 0; j < a[ i ].length; j++ )  
            output += a[ i ][ j ] + "  ";

         output += "\n";
     }
     JOptionPane.showMessageDialog( null, output,
         "2DArray Values", JOptionPane.INFORMATION_MESSAGE );
   }
}

