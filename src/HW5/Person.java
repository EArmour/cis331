/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 5
*/
package HW5;

public class Person 
{
  private String firstName;
  private String lastName;
  private int age;
  private String maritalStatus;
  private String gender;
  
  protected static int totPeople = 0;
  protected static final int MAXPEOPLE = 10;
  protected static Person[] people = new Person[MAXPEOPLE];
  

  public Person() 
  {
    this.firstName = "FIRST";
    this.lastName = "LAST";
    this.age = 0;
    this.maritalStatus = "unknown";
    this.gender = "unknown";
  }

  public Person(String firstName, String lastName, int age, 
          String maritalStatus, String gender) 
  {
    this.setfirstName(firstName);
    this.setlastName(lastName);
    this.setAge(age);
    this.setMaritalStatus(maritalStatus);
    this.setGender(gender);
  }
  
  public static boolean addPerson(String firstName, String lastName, int age, 
          String maritalStatus, String gender) 
  {
    if (totPeople == MAXPEOPLE)
      return false;
    
    people[totPeople] = new Person(firstName, lastName, age, 
            maritalStatus, gender);
    
    totPeople++;
    return true;
  }
  
  public String getfirstName() {
    return firstName;
  }

  public void setfirstName(String firstName) {
    this.firstName = (firstName.substring(0,1).toUpperCase() + 
            firstName.substring(1).toLowerCase());
  }

  public String getlastName() {
    return lastName;
  }

  public void setlastName(String lastName) {
    this.lastName = (lastName.substring(0,1).toUpperCase() + 
            lastName.substring(1).toLowerCase());;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if(age < 1)
      this.age = 0;
    else
      this.age = age;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    maritalStatus = maritalStatus.toLowerCase();
    
    if(maritalStatus.matches("married|divorced|widowed|single"))
      this.maritalStatus = maritalStatus;
    else
      this.maritalStatus = "unknown";
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    gender = gender.toLowerCase();
    
    if(gender.matches("male|female"))
      this.gender = gender;
    else
      this.gender = "unknown";
  }
  
  public static int getTotPeople()
  {
    return totPeople;
  }
  
  public static Person getPerson(int index)
  {
    return people[index];
  }
  
  public String personInfo(boolean fullData)
  {
    String info = "First: " + this.firstName + "\tLast: " + this.lastName;
    if (fullData)
      info += "\tAge: " + this.age + "\tGender: " + this.gender + 
              "\tMarital Status: " + this.maritalStatus + "\tType: " + 
              this.toString();
    return info;
  }
  
  public static double averageAge()
  {
    double avg = 0D;
    
    for (int i=0; i<totPeople; i++)
    {
      avg += people[i].getAge();
    }
    
    return (Double) avg / totPeople; 
  }
  
  public boolean equals(String testString)
  {
    if(testString.equalsIgnoreCase(this.firstName + " " + this.lastName))
      return true;
    else
      return false;
  }
  
  public static String listPersons()
  {
    String names = "";
    
    for (int i=0; i<totPeople; i++)
    {
      names += "\n" + (i+1) + ". " + people[i].getfirstName() + " " + 
              people[i].getlastName() + " (" + people[i].toString() + ")";
    }
    
    return names;
  }
  
  public static int findPerson(String searchString)
  {
    int index = -1;
    
    for (int i=0; i<totPeople; i++)
    {
      if (people[i].equals(searchString))
      {
        index = i;
        break;
      }
    }
    
    return index;
  }
  
  @Override
  public String toString()
  {
    return "Person";
  }
}