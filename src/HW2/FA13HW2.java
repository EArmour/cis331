/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 2
 * Purpose: This assignment teaches the importance of using methods to break 
 * down complicated programs into manageable chunks which interact to create the
 * entire system. Within each method, various types of loops are required, 
 * whether to display a menu or iterate through guesses in the number game. 
 * These loops often contain nested conditionals, switches, or even other loops,
 * further emphasizing the importance of keeping track of the scope of 
 * variables, bracket alignment, and program semantics in general.
*/
package HW2;

import javax.swing.JOptionPane;

public class FA13HW2 {
  public static void main (String args[]) 
  {
    if(password("casino"))
      menu(500);
    else
      JOptionPane.showMessageDialog(null, "Your Chances are UP!!\n"
              + "Get out of my casino!!!", "INCORRECT PASSWORD", 0);
  }
  
  public static boolean password(String password)
  {
    String attempt;
    
    for(int i = 0; i < 3; i++)
    {
      attempt = JOptionPane.showInputDialog(null, "Please enter the correct "
              + "password.\nYou have " + (3-i) + " chances remaining", 
              "Incorrect Password!", 3);
      
      if(attempt.equals(password))    
        return true; 
    }
    
    return false;
  }
  
  
  public static void menu(int money)
  {
    int choiceInt;
    
    do 
    {
      String choice = JOptionPane.showInputDialog(null, "Choose an option:\n"
              + "1: Play the Number Game\n"
              + "2: Play Blackjack\n"
              + "3: Play Poker\n"
              + "4: Count Your Money\n"
              + "5: Quit",
              "Welcome to the Java Casino!", 3);

      try 
      {
        choiceInt = Integer.parseInt(choice);
      } 
      catch (NumberFormatException e) 
      {
        choiceInt = 6;
      }
      
      switch(choiceInt)
      {
        case 1:
          money = bet(money);
          break;
        case 2:
          JOptionPane.showMessageDialog(null,"Blackjack is under construction!"
                  + "\nPlease try again later.", "Blackjack", 1);
          break;
        case 3:
          JOptionPane.showMessageDialog(null, "Poker is under construction!"
                  + "\nPlease try again later.", "Poker", 1);
          break;
        case 4:
        {
          String message = ("You have $" + Integer.toString(money) + "!\n");
          
          if(money == 500)
            message += "So let's start winning some money!";
          else if(money > 500)
            message += "You can leave a winner... or keep playing and win big!";
          else if(money < 500)
            message += "I can feel your luck changing... play some more!";
          
          JOptionPane.showMessageDialog(null, message, "Money Count", 1);
          break;
        }
        case 5:
          break;
        default:
          JOptionPane.showMessageDialog(null, "Hey, that's not a valid choice!"
                  + "\nTry again!", "Invalid Choice", 0);
          break;
      }
    } while(choiceInt != 5 && money != 0);
    
    String message = "";
    
    if(money == 500)
      message += "You've got no ambition!\nWe're even!";
    else if(money > 500)
      message += ("Lucky break! Guess I owe you $" + 
              Integer.toString(money - 500) + "!");
    else if(money < 500)
      message += "The house always wins! You owe me $" + 
              Integer.toString(500 - money) + "!";

    JOptionPane.showMessageDialog(null, message, "Money Count", 1);
  }

  public static int bet(int money)
  {
    int bet;
    
    JOptionPane.showMessageDialog(null, 
            "You get 4 chances to pick a number between 1-30 \n" +
            "If you choose a number outside of this range, you automatically "
            + "lose!\n" +
            "\nYou must place a bet ($5 increments) that is lower than the "
            + "amount of money you have.\n" +
            "Each INCORRECT bet will cost you $5!!\n" +
            "You will be kicked out of the casino if you lose all of your "
            + "money!\n" +
            "\nPAYOUTS:\n 1st Try = 10 * Bet\n 2nd Try = 5 * Bet\n "
            + "3rd Try = 3 * Bet\n 4th Try = 2 * Bet\n", 
            "Instructions", 1);
    
    do
    {
      String betString = JOptionPane.showInputDialog(null, "You now have $" +
              Integer.toString(money) + ".\nPlace your bet, in a $5 increment"
              , "Place Your Bet!", 3);
      try 
      {
        bet = Integer.parseInt(betString);
      } 
      catch (NumberFormatException e) 
      {
        bet = -12345;
      }
      
      if(bet == -12345)
      {
        JOptionPane.showMessageDialog(null, "Hey, you have to use integers!", 
               "ERROR", 0);
        continue;
      }
      
      if(bet > money)
      {
        JOptionPane.showMessageDialog(null, "You ain't got that much!", 
                "ERROR", 0);
        continue;
      }
      
      if(bet < 1)
      {
        JOptionPane.showMessageDialog(null, "You have to bet a positive amount"
                , "ERROR", 0);
        continue;
      }
      
      if(bet % 5 != 0)
      {
        JOptionPane.showMessageDialog(null, "Didn't I say increments of $5?"
                , "ERROR", 0);
        continue;
      }
      
      break;
    }while((money -= 5) != 0);
     
    return money + numberGame(bet);
  }
  
  public static int numberGame(int money)
  {
    String guessString;
    int guess, winnings = 0;
    int target = 1 + (int)(Math.random() * 29D);
    
    for(int i = 0; i < 4; i++)
    {
      guessString = JOptionPane.showInputDialog(null, "Guess a number!\n"
              + "You have " + (4-i) + " chances remaining", "Guess!", 3);
      try 
      {
        guess = Integer.parseInt(guessString);
      } 
      catch (NumberFormatException e) 
      {
        guess = 0;
      }
      
      if(guess == target)
      {
        switch(i)
        {
          case 0:
            winnings = money * 10;
            break;
          case 1:
            winnings = money * 5;
            break;
          case 2:
            winnings = money * 3;
            break;
          case 3:
            winnings = money * 2;
            break;
        }
        JOptionPane.showMessageDialog(null, "You got it! That means you win $"
                + Integer.toString(winnings)
                , "Right Guess!", 1);
        return winnings;
      }
      else if(guess < 1 || guess > 30)
      {
        JOptionPane.showMessageDialog(null, "You're just not very good at "
                + "following directions, are you?\nThat means you lose!"
                , "Invalid Guess!", 0);
        break;
      }
      else if(guess > target)
        JOptionPane.showMessageDialog(null, "That guess is too high!"
                , "Wrong Guess!", 1);
      else
        JOptionPane.showMessageDialog(null, "That guess is too low!"
                , "Wrong Guess!", 1);
    }
    
    JOptionPane.showMessageDialog(null, "Oh no! Looks like you're a loser!\n"
            + "That means you lose your $" + Integer.toString(money) + " bet!"
            + "\nBy the way, the number was " + Integer.toString(target)
            , "You Lose!", 0);
    winnings = -money;
    return winnings;
  }
}