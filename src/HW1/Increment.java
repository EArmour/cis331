/* Example 1 -  Increment and Decrement Operators*/

import javax.swing.JOptionPane;

public class Increment
{
   	public static void main( String args[] )
   	{
            int i=5, j=5, k=5; 
            String result = "";
 		
            result += "i=" +i +";  j=" +j +";  k=" +k;
		
            //The Problems
            i  += j++ *  --k;
            result += "\n\ni  += j++ *  --k;\ni=" +i +";  j=" +j +";  k=" +k;
            i  += --j +  --k;	
            result += "\n\ni  += --j +  --k;\ni=" +i +";  j=" +j +";  k=" +k;              
  		
            i  -=  i--;
            result += "\n\ni  -=  i--;\ni=" +i +";  j=" +j +";  k=" +k;              
  		
            JOptionPane.showMessageDialog( null, result, "Results",JOptionPane.PLAIN_MESSAGE);    										
   }
}
