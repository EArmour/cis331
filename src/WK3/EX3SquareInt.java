// A programmer-defined square method

import javax.swing.*;

public class EX3SquareInt
{
   public static void main( String args[] )
   {
     int result;
     String output = "";
     
     JTextArea outputArea = new JTextArea( 10, 20 );
     
     for ( int x = 1; x <= 10; x++ ) 
     {
       result = square( x );
       output += "The square of " + x +
                 " is " + result + "\n";
      }
      outputArea.setText( output );
      
      JOptionPane.showMessageDialog(null, outputArea, "SQUARE",
         JOptionPane.INFORMATION_MESSAGE );
      
   }
   // square method definition 
   static public int square( int y )
   {
      return y * y;
   }
}

