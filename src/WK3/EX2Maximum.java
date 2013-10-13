// Fig. 6.4: Maximum.java
// Finding the maximum of three doubles

import javax.swing.*;

public class EX2Maximum
{
   public static void main( String args[] )
   {
      JTextArea outputArea = new JTextArea();

      String s1 = JOptionPane.showInputDialog(
                     "Enter first value" );
      String s2 = JOptionPane.showInputDialog(
                     "Enter second value" );
      String s3 = JOptionPane.showInputDialog(
                     "Enter third value" );

      double number1 = Double.parseDouble( s1 );
      double number2 = Double.parseDouble( s2 );
      double number3 = Double.parseDouble( s3 );

      double max = maximum( number1, number2, number3 );

      outputArea.setText( "Number1: " + number1 +"\nNumber2: " + number2 +
                          "\nNumber3: " + number3 +"\n\nMaximum is: " + max );

      JOptionPane.showMessageDialog(null, outputArea, "MAX",
         JOptionPane.INFORMATION_MESSAGE );
   }
   
   static public double maximum( double x, double y, double z )
   {
      return Math.max( x, Math.max( y, z ) );
   }
}