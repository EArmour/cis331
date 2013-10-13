
package textfileexamples;
import java.io.*;
import java.util.*;
public class TextFileIOWithScannerAndStringTokenzier {    
    public static void main(String[] args) {
        try{
            // create file and scanner for input
            File inputFile = new File("c:/temp/nbrfile.txt");
            Scanner scanner = new Scanner(inputFile);
            // create file and writer for output
            File outputFile = new File("c:/temp/outfile.txt");
            PrintWriter pWriter = new PrintWriter(outputFile);            
            // outer loop keeps going as long as there are any tokens to read
            while (scanner.hasNextLine()){                
                // read an entire line from the files
                String line = scanner.nextLine();
                // create a StringTokenizer 
                StringTokenizer st = new StringTokenizer(line);
                // initialize variables
                double tot=0.0;
                String operator = " ";
                // loop through all the tokens in the string 
                while (st.hasMoreTokens()){
                      String token = st.nextToken();
                      if (Character.isDigit(token.charAt(0))){
                        // in this case, the token is a number
                        double nbr=Double.parseDouble(token);
                        System.out.print(operator + nbr);
                        pWriter.print(operator + nbr);
                        operator = " + ";
                        tot += nbr;                          
                      }
                      else{
                        // in this case, the token is NOT a number
                        System.out.print(token);
                        pWriter.print(token);                          
                      }                          
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


