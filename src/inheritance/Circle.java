package inheritance;
public class Circle {
  /** The radius of the circle */
  private double radius;
  public final double PI = 3.14159;

  /** Construct a circle with radius 1 */
  public Circle() {
    radius = 1.0;
  }

  /** Construct a circle with a specified radius */
  public Circle(double newRadius) {
    radius = newRadius;
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double newRadius) {
    radius = (newRadius >= 0) ? newRadius : 0;
  }

  /** Return the area of this circle */
  public double findArea() {
    return radius * radius * 3.14159;
  }

}
