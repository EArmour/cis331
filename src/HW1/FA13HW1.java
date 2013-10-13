/** Author: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 1
 * Purpose: Writing this program teaches many fundamental structures and features that are useful in virtually all programs. If-else statements, their nesting, and tracking brackets are the most dominant objective to master, but we also learn about getting input and displaying messages to the user through the JOptionPane class, and the different ways of comparing values of different data types.
 */
package HW1;
import javax.swing.*;

public class FA13HW1
{
    public static void main(String[] args) 
    {
      double balance = 500.0, bet;
      int choice;
      String password;
      
      password = JOptionPane.showInputDialog(null, "Please Enter Password", "HOMEWORK #1", 1);
        
      if(password.equals("casino"))
      {
        choice = Integer.parseInt(JOptionPane.showInputDialog(null, "What game would you like to play?\n1 = Blackjack\n2 = Poker\n3 = Leave", "Welcome to the Java Casino!", 1));
          if(choice == 1)
          {
            bet = Double.parseDouble(JOptionPane.showInputDialog(null, "You have $500\nPlease Place your Bet!", "Welcome to Blackjack!", 1));
            
            if(bet > balance)
              JOptionPane.showMessageDialog(null, "You do not have enough money!", "GET OUT!!!", 0);
            else
              JOptionPane.showMessageDialog(null, "Deal Cards for Blackjack!", "Welcome to Blackjack!", 1);
            }
            
          else if(choice == 2)
          {
            bet = Double.parseDouble(JOptionPane.showInputDialog(null, "You have $500\nPlease Place your Bet!", "Welcome to Poker!", 1));
            
            if(bet > balance)
              JOptionPane.showMessageDialog(null, "You do not have enough money!", "GET OUT!!!", 0);
            else
              JOptionPane.showMessageDialog(null, "Deal Cards for Poker!", "Welcome to Poker!", 1);
          }
            
          else
            JOptionPane.showMessageDialog(null, "Thank you for Choosing the Java Casino!", "See Ya Later!", 1);
      }
      
      else
        JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD", "GET OUT!!!", 0);
    }
}