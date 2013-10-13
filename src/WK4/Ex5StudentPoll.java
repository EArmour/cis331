// Example 5 Frequency
import javax.swing.*;

public class Ex5StudentPoll 
{
   public static void main( String args[] )
   {
      int responses[] = { 1, 2, 6, 4, 8, 5, 9, 7, 8, 10,
                          1, 6, 3, 8, 6, 10, 3, 8, 2, 7,
                          6, 5, 7, 6, 8, 6, 7, 5, 6, 6,
                          5, 6, 7, 5, 6, 4, 8, 6, 8, 10 };
     
      int frequency[] = new int[ 11 ];
      String output = "";

      for ( int answer = 0; answer < responses.length; answer++ )        
         ++frequency[ responses[ answer ] ];

      output += "Rating\tFrequency\n";
   
      for ( int rating = 1; rating < frequency.length; rating++ )
         output += rating + "\t" + frequency[ rating ] + "\n";

      JTextArea outputArea = new JTextArea( 11, 10 );
      outputArea.setText( output );

      JOptionPane.showMessageDialog( null, outputArea, "Student Poll Program",
         JOptionPane.INFORMATION_MESSAGE );
   }
}