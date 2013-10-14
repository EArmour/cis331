package polymorphismexample;
import javax.swing.*;

public class TestCircleCylinderSphere
{
  public static void main(String[] args)
  {
      Circle[] circles = new Circle[3];

      // here, we don't know whether the array element will point ot a
      // circle, a cylinder, or a sphere!!!
      for (int i=0;i<circles.length;i++){
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, 
                   "Enter 1 for Circle, 2 for Cylinder, or 3 for Sphere",
                   "Polymorphism Example",JOptionPane.QUESTION_MESSAGE));
        switch (choice){
          case 1:
            circles[i] = new Circle(5.0);
            break;
          case 2:
            circles[i] = new Cylinder(5.0,2.0);
            break;
          case 3:
            circles[i] = new Sphere(5.0);
            break;
        }
      }

      for (int i=0;i<circles.length;i++){
          // cause the toString overridden methods to be invoked  
          System.out.println(i + ")  " + circles[i]);
          
          // the getClass method of the Object class will tell you exactly
          // what is the class of a given instance
          System.out.println("Element " + i + " is an instance of " + circles[i].getClass());

          // Which version of the findArea method will be called??
          // It depends on the instance.
          // This is the beauty of polymorphism...This is dynamic (runtime) binding!!!
          // A very powerful feature of object-oriented programming!!
          double area = circles[i].findArea();
          System.out.println("   Area is: " + area);


          // the instanceof operator allows you to test whether an object is
          // an instance of a particular class...very useful for some purposess
          if (circles[i] instanceof Cylinder){
                                // note the casting here...I need to do this
                                // because Circle don't have
                                // findVolume method
              double volume = ((Cylinder)circles[i]).findVolume();
              System.out.println("   Volume is: " + volume);
          }
          else if (circles[i] instanceof Sphere){
                                // casting again
              double volume = ((Sphere)circles[i]).findVolume();
              System.out.println("   Volume is: " + volume);
        }
    } 
  }
}

