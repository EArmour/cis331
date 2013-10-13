// Example4 - Using Nested if statements
import javax.swing.JOptionPane;
public class Example4 
{
   	public static void main( String args[] )
   	{
      	String firstNumber, secondNumber, result = "";
      	int number1,  number2;

      	firstNumber = JOptionPane.showInputDialog( "Enter first integer:" );
      	secondNumber = JOptionPane.showInputDialog( "Enter second integer:" );          

      	number1 = Integer.parseInt( firstNumber );
      	number2 = Integer.parseInt( secondNumber );

      	if ( number1 == number2 )
      	{
         	result = number1 + " == " + number2;
         	result = result + "\n" + number1 + " <= " + number2;
			result = result + "\n" + number1 + " >= " + number2;
		}
      	else
      	{
         	result = number1 + " != " + number2;

      		if ( number1 < number2 )
      		{
         		result = result + "\n" + number1 + " < " + number2;
         		result = result + "\n" + number1 + " <= " + number2;
         	}
      		else
      		{
         		result = result + "\n" + number1 + " > " + number2;
         		result = result + "\n" + number1 + " >= " + number2;
         	}
		}
      	JOptionPane.showMessageDialog(null, result, "Comparison Results", JOptionPane.INFORMATION_MESSAGE );
   }
}
