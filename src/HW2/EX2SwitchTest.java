// Simple Switch
import javax.swing.JOptionPane;

public class EX2SwitchTest
{       
  public static void main( String args[] )
  {
      int choice;
      String input, output = "";

      input = JOptionPane.showInputDialog( 
                 "Enter 1 for Deluxe wash\n" +
                 "Enter 2 for Good wash\n" +
                 "Enter 3 for Crappy wash\n" );

      choice = Integer.parseInt( input );
      
      switch( choice ) 
      {
         case 1:
           output += "Deluxe Wash\n";
           break;
         case 2:
           output += "Good Wash\n";;
           break;
         case 3:
           output += "Crappy Wash\n";
           break;
         default:
           output += "Invalid value entered\n";
           
      }
      JOptionPane.showMessageDialog(null, output);
  }
}
            


