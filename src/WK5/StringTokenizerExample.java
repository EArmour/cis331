

package stringexamples;

import java.util.StringTokenizer;
public class StringTokenizerExample {
  public static void main(String[] args) {
    String s = "This is a test string with spaces as delimiters.";
    
    // by default, the delimiters are spaces, tabs, and end-of-line characters
    StringTokenizer tokenizer = new StringTokenizer(s);

    System.out.println("The total number of tokens is " +
      tokenizer.countTokens());

    // this loop will keep getting tokens as long as any are left
    while (tokenizer.hasMoreTokens())
      System.out.println(tokenizer.nextToken());

    // note: countTokens returns the number of tokens REMAINING...
    // so it changes as you get each subsequent token
    System.out.println("Any tokens left? " + tokenizer.countTokens());
    System.out.println("\n");
    
    
    // try tokenizing with other than the default delimiters
    s = "Now we have_a string with hyphens-and underscores_as delimiters.";
    tokenizer = new StringTokenizer(s,"-_");        
    // this loop will keep getting tokens as long as any are left
    while (tokenizer.hasMoreTokens())
      System.out.println(tokenizer.nextToken());
    System.out.println("\n");
    
    // with the same string, try tokenizing with returning the delimeters
    // each delimiter is returned as an individual token
    tokenizer = new StringTokenizer(s,"-_",true);        
    // this loop will keep getting tokens as long as any are left
    while (tokenizer.hasMoreTokens())
      System.out.println(tokenizer.nextToken());
    System.out.println("\n");
    
  }
}
