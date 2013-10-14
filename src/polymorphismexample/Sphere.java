package polymorphismexample;


public class Sphere extends Circle
{

  public Sphere()
  {
  }
  public Sphere(double r)
  {
    super(r);
  }

  public double findArea(){
    return 4*Math.PI*getRadius()*getRadius();
  }
  public double findVolume(){
    return 4/3*Math.PI*getRadius()*getRadius()*getRadius();
  }
  
  public String toString() {
    return "This is a sphere";
  }
  
}