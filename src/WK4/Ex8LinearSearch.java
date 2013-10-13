// Example 8 - Linear Search
import javax.swing.*;

public class Ex8LinearSearch
{
   public static void main( String args[] )
   {
      JTextArea outputArea = new JTextArea();
      
      int a[] = { 2, 6, 4, 8, 10, 12, 89, 68, 45, 37 };
      
      String input = JOptionPane.showInputDialog("Enter value to search for" );
      
      int value = Integer.parseInt(input);
      
      int subscript = linearSearch(a, value);
      
      if (subscript != -1)
        JOptionPane.showMessageDialog( null, "The value " +value 
                +" is element number " +(subscript + 1), "Linear Search",
                JOptionPane.INFORMATION_MESSAGE );
      else
        JOptionPane.showMessageDialog( null, "VALUE NOT FOUND", 
                "Linear Search", JOptionPane.INFORMATION_MESSAGE );
   }
   // Search "array" for the specified "key" value
   public static int linearSearch( int array[], int key ) 
   {   
      for ( int n = 0; n < array.length; n++ ) 
         if ( array[ n ] == key )
            return n;

      return -1;
   }
}

   