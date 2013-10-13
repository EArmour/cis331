// While versus Do While Loops
import javax.swing.*;
public class EX3WhileVsDoWhile 
{
  public static void main(String[] args) 
  {
     int counter = 0;
     int loopCount = 0;
     
     while ( ++counter <= 3 ) 
     {
        loopCount++;
     }
     JOptionPane.showMessageDialog(null, "The number of times this "
              + "\"while\" loop executed was " +loopCount);
     
     counter = 0;
     loopCount = 0;
      
     do 
     {
        loopCount++;
     } while ( ++counter <= 3 );
     JOptionPane.showMessageDialog(null, "The number of times this "
              + "\"do while\" loop executed was " +loopCount);   
  }
}
