/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 1
 * Purpose:
*/
package inheritance;

public class Sphere extends Circle {

  public Sphere()
  {}
  
  public Sphere(double radius)
  {
    super(radius);
  }
  
  @Override
  public double findArea()
  {
    return 4 * super.findArea();
  }
  
  public double findVolume()
  {
    return findArea() * getRadius() / 3;
  }

}
