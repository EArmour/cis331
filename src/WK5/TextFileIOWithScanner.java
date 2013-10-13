
package textfileexamples;
import java.io.*;
import java.util.*;
public class TextFileIOWithScanner {    
    public static void main(String[] args) {
        // reading from a file, displaying sum of numbers in each line of the file
        // NOTE: each line may have a different number of values to add      
        try{
            // create file and scanner for input
            File inputFile = new File("c:/temp/nbrfile.txt");
            Scanner scanner = new Scanner(inputFile);

            // create file and writer for output
            File outputFile = new File("c:/temp/outfile.txt");
            PrintWriter pWriter = new PrintWriter(outputFile);
            
            // outer loop keeps going as long as there are any tokens to read
            while (scanner.hasNext()){
                double tot=0.0;
                String operator = " ";

                // get the line's label
                String label = scanner.next();
                System.out.print(label + "\t");
                pWriter.print(label + "\t");
                
                // loop to read and sum all the values of a line 
                // (assumes all remaining tokens are numbers)
                while (scanner.hasNextDouble()){
                      double nbr=scanner.nextDouble();
                      System.out.print(operator + nbr);
                      pWriter.print(operator + nbr);
                      operator = " + ";
                      tot += nbr;
                }
        
                System.out.println(" = " + tot);             
                pWriter.println(" = " + tot); 
            }
            // close the file
            pWriter.close();
        }
        catch (Exception e){
            System.out.println("Error reading file: " + e.toString());            
        }
    }   
}


