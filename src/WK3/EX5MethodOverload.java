//Overloading, IMMUTABLE Strings, Pass by Reference

import javax.swing.JOptionPane;

public class EX5MethodOverload
{
  public static void main( String args[] )
  {
    String result = "RESULT STRING\n";
    StringBuilder zText = new StringBuilder("ZTEXT STRING\n");
    int x;
    double y;
    
    x = square( 7, result );
    
    JOptionPane.showMessageDialog(null, result, "IMMUTABLE",
         JOptionPane.INFORMATION_MESSAGE );
    
    result += "Some stuff\n";
    
    y = square( 7.5, zText );
    
    JOptionPane.showMessageDialog(null, zText, "PASS BY REFERENCE",
         JOptionPane.INFORMATION_MESSAGE );
    
    
    result += "The square of integer 7 is " +x  
            +"\nThe square of double 7.5 is " +y ;

    JOptionPane.showMessageDialog(null, result, "FINAL RESULTS",
         JOptionPane.INFORMATION_MESSAGE );

  }
  static public int square( int x, String y )
  {
     y += "Int was called\n";
     JOptionPane.showMessageDialog(null, y, "SQUARE METHOD (int, String)",
         JOptionPane.INFORMATION_MESSAGE );
     
     return x * x;
  }

  static public double square( double y, StringBuilder x )
  {
     x.append("Double was called\n");
     JOptionPane.showMessageDialog(null, x, 
             "SQUARE METHOD (double, StringBuilder)", 
             JOptionPane.INFORMATION_MESSAGE );
     
     return y * y;
  }
}

