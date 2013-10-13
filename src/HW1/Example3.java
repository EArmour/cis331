// Example3 - Improper use of IF/ELSE IF/ELSE Structure!
import javax.swing.JOptionPane;
public class Example3 
{
   	public static void main( String args[] )
   	{
      	String firstNumber, secondNumber, result = "";       
      	int number1, number2;         

      	firstNumber = JOptionPane.showInputDialog( "Enter first integer:" );
      	secondNumber = JOptionPane.showInputDialog( "Enter second integer:" );          

      	number1 = Integer.parseInt( firstNumber );
      	number2 = Integer.parseInt( secondNumber );

      	if ( number1 == number2 )
         	result = number1 + " == " + number2;

      	else if ( number1 != number2 )
         	result = number1 + " != " + number2;

      	else if ( number1 < number2 )
         	result = result + "\n" + number1 + " < " + number2;

      	else if ( number1 > number2 )
         	result = result + "\n" + number1 + " > " + number2;

      	else if ( number1 <= number2 )
         	result = result + "\n" + number1 + " <= " + number2;

      	else
         	result = result + "\n" + number1 + " >= " + number2;

      	JOptionPane.showMessageDialog(null, result, "Comparison Results", JOptionPane.INFORMATION_MESSAGE );
   }
}
