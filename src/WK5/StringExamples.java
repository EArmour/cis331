/*
 *   This example shows some of the features of the String class
 *
 *
 */

package stringexamples;

public class StringExamples
{
  public static void main(String[] args)
  {

      // initialize two string objects to point to a literal string
      // which is in the constants pool
      String s1 = "a string";
      String s2 = "a string";

      // test for identical reference
      if (s1==s2)
        System.out.println("the string references point to the same object");
      else
        System.out.println("the string references point to different objects");

      // test for equal value
      if (s1.equals(s2))
        System.out.println("the string contents are equal");
      else
        System.out.println("the string contents are not equal");

      // instantiate two string objects
      s1 = new String("a string");
      s2 = new String("a string");

      // test for identical reference
      if (s1==s2)
        System.out.println("the string references point to the same object");
      else
        System.out.println("the string references point to different objects");

      // test for equal value
      if (s1.equals(s2))
        System.out.println("the string contents are equal");
      else
        System.out.println("the string contents are not equal");

      // changing s2 to point to another string from the constants pool
      s2 = "another string";
      // test for equal value
      if (s1.equals(s2))
        System.out.println("the string contents are equal");
      else
        System.out.println("the string contents are not equal");

      // make s1 point to the same string s2 is pointing to
      s1=s2;
      // test for equal value
      if (s1.equals(s2))
        System.out.println("the string contents are equal");
      else
        System.out.println("the string contents are not equal");
      // test for identical reference
      if (s1==s2)
        System.out.println("the string references point to the same object");
      else
        System.out.println("the string references point to different objects");

      // convert to upper case
      System.out.println("Upper Case: " + s1.toUpperCase());
      // get a substring
      System.out.println("Substring: " + s1.substring(3,6));
      // convert a substring to upper case
      System.out.println("Upper Case Substring: " + s1.substring(3,6).toUpperCase());

  }
}

