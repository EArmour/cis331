// Example2 - Using Simple if statements
import javax.swing.JOptionPane;
public class Example2 
{
   	public static void main( String args[] )
   	{
      	String firstNumber, secondNumber, result = "";        
      	int number1, number2;          

      // read numbers from user as a strings
      	firstNumber = JOptionPane.showInputDialog( "Enter first integer:" );
      	secondNumber = JOptionPane.showInputDialog( "Enter second integer:" );          

      // convert numbers from type String to type int
      	number1 = Integer.parseInt( firstNumber );
      	number2 = Integer.parseInt( secondNumber );
      	
	  // multiple if statements
      	if ( number1 == number2 )
         	result = number1 + " == " + number2;

      	if ( number1 != number2 )
         	result = number1 + " != " + number2;

      	if ( number1 < number2 )
         	result = result + "\n" + number1 + " < " + number2;

      	if ( number1 > number2 )
         	result = result + "\n" + number1 + " > " + number2;

      	if ( number1 <= number2 )
         	result = result + "\n" + number1 + " <= " + number2;

      	if ( number1 >= number2 )
         	result = result + "\n" + number1 + " >= " + number2;
    	
      // Display results
      	JOptionPane.showMessageDialog(null, result, "Comparison Results", JOptionPane.INFORMATION_MESSAGE );
   }
}
