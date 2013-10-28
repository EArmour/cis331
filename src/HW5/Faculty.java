/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 5
*/
package HW5;

public class Faculty extends Person {
  
  private String rank;
  
  public Faculty()
  {
    super();
    this.rank = "assistant professor";
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
    
    totPeople++;
    return true;
  }

  public String getRank() {
    return rank;
  }
  
  public void setRank(String rank)
  {
    rank = rank.toLowerCase();
    this.rank = (rank.matches("instructor|full professor")) 
            ? rank : "assistant professor";
  }
  
  @Override
  public String toString() {
    return "Faculty";
  }
  
  @Override
  public String personInfo(boolean fullData)
  {
    String info = super.personInfo(false);
    if (fullData)
      info = super.personInfo(true) + "\tRank: " + this.getRank();
    
    return info;
  }
}