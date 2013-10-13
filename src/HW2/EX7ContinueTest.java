// Continue Test
import javax.swing.JOptionPane;

public class EX7ContinueTest 
{
   public static void main( String args[] )
   {
      String output = "";

      for ( int count = 1; count <= 10; count++ ) 
      {
         if ( count == 5 )
            continue;
         output += count + " ";
      }
      output += "\nUsed continue to skip printing 5";

      JOptionPane.showMessageDialog( null, output );

   }
}
