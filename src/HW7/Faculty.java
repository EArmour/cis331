/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 7
*/
package HW7;

public class Faculty extends Person {
  
  public static int totFaculty = 0;
  public static int[] faculty = new int[100];
  
  private String rank;
  
  public Faculty()
  {
    super();
    this.rank = "AP";
  }
  
  public Faculty(String firstName, String lastName, int age, 
          String maritalStatus, String gender, String rank) 
  {
    super(firstName, lastName, age, maritalStatus, gender);
    this.setRank(rank);
  }
  
public static boolean addFaculty(String firstName, String lastName, int age, 
          String maritalStatus, String gender, String rank) 
  {
    if (totPeople == MAXPEOPLE)
      return false;
    
    people[totPeople] = new Faculty(firstName, lastName, age, 
            maritalStatus, gender, rank);
    faculty[totFaculty] = totPeople;
    
    totFaculty++;
    totPeople++;
    return true;
  }

  public String getRank() {
    return rank;
  }
  
  public void setRank(String rank)
  {
    this.rank = rank;
  }
  
  @Override
  public String personInfo(boolean fullData)
  {
    String info = super.personInfo(false);
    if (fullData)
      info = super.personInfo(true) + "\tRank: " + this.getRank();
    
    return info;
  }
  
  public static String getSymbol(String rank)
  {
    rank = rank.toLowerCase();
    rank = (rank.matches("instructor|full professor"))
            ? rank : "assistant professor";
    if(rank.equals("instructor"))
      return "I";
    else if (rank.equals("full professor"))
      return "FP";
    else
      return "AP";
  }
  
  public static boolean updateDB(int index)
  {
    return true;
  }
}