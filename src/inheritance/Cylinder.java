package inheritance;
public class Cylinder extends Circle {
  /** length of this cylinder */
  private double length;

  /** Construct a cylinder with default radius and length */
  public Cylinder() {
    super(); // Default behavior and can be omitted
    length = 1.0;
  }

  /** Construct a cylinder with specified radius and length */
  public Cylinder(double radius, double length) {
    super(radius);
    this.length = length;
  }

  /** Return length */
  public double getLength() {
    return length;
  }

  /** Set length */
  public void setLength(double length) {
    this.length = length;
  }

  /** Return the surface area of this cylinder. The formula is
   * 2 * circle area + cylinder body area
    */
  public double findArea() {
    return 2 * super.findArea() + 2 * getRadius() * Math.PI * length;
  }

  /** Return the volume of this cylinder */
  public double findVolume() {
    return super.findArea() * length;
  }

  /** Override the toString method */
  public String toString() {
    return "Cylinder length = " + length +
      " radius = " + getRadius();
  }
}
