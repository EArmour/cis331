package javaapplication1; //A Folder of Classes
public class JavaApplication1 
{
    public static void main(String[] args) 
    {
        Pet dog1 = new Dog();
        
        PetLover petLover1 = new PetLover ("Afton");
        
        dog1.setName("SadEyes");
        
        petLover1.lovePet(dog1);
    }
}

/*      Cat cat1 = new Cat();
        
        Cat cat1 = new Cat(); 
        
        JOptionPane.showMessageDialog
                (null, "My name is " +cat1.getName());
        
        cat1.setName("Slim Shady");
        
        JOptionPane.showMessageDialog
                (null, "My name is " +cat1.getName());
        * 
        * 
        * 
        * 
        * JOptionPane.showMessageDialog
                (null, "My name is " +cat1.getName());
        cat1.name = "Sparkles";
        JOptionPane.showMessageDialog
                (null, "My name is " +cat1.name);
                
              Dog dog1 = new Dog();
        PetLover petLover1 = new PetLover ("Susan");
        dog1.setName("SadEyes");
        petLover1.lovePet(dog1);
        * 
                Cat cat1 = new Cat();
        JOptionPane.showMessageDialog
                (null, "My name is " +cat1.getName());
        cat1.setName("Sparkles");
        JOptionPane.showMessageDialog
                (null, "My name is " +cat1.name);
        cat1 = null;
        
     
         Dog dog1 = new Dog();
        
        PetLover petLover1 = new PetLover ("Afton");
        
        dog1.setName("SadEyes");
        
        petLover1.lovePet(dog1);
        cat1 = null;
        * 
        * 
        * Cat cat1 = new Cat();

        JOptionPane.showMessageDialog
                (null, "My age is " +cat1.getAge());
        
        cat1.setAge(50);
        
        JOptionPane.showMessageDialog
                (null, "My age is " +cat1.getAge());
    }
        
        
        */