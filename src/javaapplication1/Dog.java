package javaapplication1;
public class Dog extends Pet
{
    private int weight;
   
    public Dog(){weight = 0;}
    public int getWeight() {return weight;}
    public void setWeight(int newWeight){
        weight = newWeight;}
    @Override
    public String sayHello(){return "BARK!";}
}



