// Scope

import javax.swing.JOptionPane;

public class EX4Scope
{
  static String result = "";
  static int x = 1;      // instance variable
  
  public static void main( String args[] )
  {
    int x = 5;   // variable local to main

    result += "local x in main is " + x ;

    methodA();   // methodA has automatic local x
    methodB();   // methodB uses instance variable x
    methodA();   // methodA reinitializes automatic local x
    methodB();   // instance variable x retains its value

    JOptionPane.showMessageDialog(null, result, "RESULTS",
         JOptionPane.INFORMATION_MESSAGE );
      
   }

  static public void methodA()
  {
    int x = 25;  // initialized each time a is called

    result += "\n\nlocal x in methodA is " + x +" after entering methodA" ;
    ++x;
    result += "\nlocal x in methodA is " + x +" before exiting methodA" ;
  }

  static public void methodB()
  {
    result += "\n\ninstance variable x is " + x +" on entering methodB" ;
    x *= 10;
    result += "\ninstance variable x is " + x +" on exiting methodB" ;
  }
}   
