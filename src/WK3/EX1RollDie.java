// Random Numbers
import javax.swing.*;

public class EX1RollDie 
{
 public static void main( String args[] )
 {
    int frequency1 = 0, frequency2 = 0, frequency3 = 0, frequency4 = 0,
        frequency5 = 0, frequency6 = 0, face;

    for ( int roll = 1; roll <= 6000; roll++ ) 
    {
       face = 1 + (int) ( Math.random() * 6 );
       switch ( face ) 
       {
          case 1:
             ++frequency1;
             break;
          case 2:
             ++frequency2;
             break;
          case 3:
             ++frequency3;
             break;
          case 4:
             ++frequency4;
             break;
          case 5:
             ++frequency5;
             break;
          case 6:
             ++frequency6;
             break;
       }
    }
    JTextArea outputArea = new JTextArea( 7, 10 );

    outputArea.setText("Face\tFrequency" +"\n1\t" + frequency1 +
       "\n2\t" + frequency2 +"\n3\t" + frequency3 +"\n4\t" + frequency4 +
       "\n5\t" + frequency5 +"\n6\t" + frequency6 );

    JOptionPane.showMessageDialog( null, outputArea,
       "Rolling a Die 6000 Times", JOptionPane.INFORMATION_MESSAGE );
 }
}
