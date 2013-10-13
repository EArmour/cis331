package javaapplication1;
import javax.swing.JOptionPane;

public class PetLover 
{
    private String name;
    public PetLover(){name  = "No Name";} 
    public PetLover(String nName){name  = nName;} //Overloaded Constructor
    
    public void lovePet(Pet pet)
    {
        String text = "Hi my name is " +name +"\n\n";
        text += pet.sayHello();
        text += "\n\nI am so happy you have found me " +pet.getName() +"\n\n";
        text += "I Love You!!!\n\n Along with all other objects ";
        text += "that inherit from the Pet Class!!";
        JOptionPane.showMessageDialog(null, text);
        
        //pet.setWeight(22); <--CAN'T DO THIS
    }          
}

    
//}
