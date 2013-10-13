// Example 8 - Bubble Sort
import javax.swing.*;

public class Ex9BubbleSort
{
   public static void main( String args[] )
   {
      JTextArea outputArea = new JTextArea();
      int a[] = { 2, 6, 4, 8, 10, 12, 89, 68, 45, 37 };
      String output = "Data items in original order\n";

      for ( int i = 0; i < a.length; i++ ) 
         output += "   " + a[ i ];
 	
      bubbleSort( a );

      output += "\n\nData items in ascending order\n";

      for ( int i = 0; i < a.length; i++ ) 
         output += "   " + a[ i ];

      outputArea.setText( output );
      
      JOptionPane.showMessageDialog( null, outputArea,
         "Passing Arrays",
         JOptionPane.INFORMATION_MESSAGE );
   }
   
   public static void bubbleSort( int b[] )
   {   
      for ( int pass = 1; pass < b.length; pass++ ) // passes
         for ( int i = 0; i < b.length - 1; i++ ) // one pass   
            if ( b[ i ] > b[ i + 1 ] )        // one comparison
               swap( b, i, i + 1 );           // one swap
   }

   // swap two elements of an array
   public static void swap( int c[], int first, int second )
   {
      int hold;  // temporary holding area for swap

      hold = c[ first ];         
      c[ first ] = c[ second ];  
      c[ second ] = hold;
   }
}