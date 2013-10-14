package polymorphismexample;
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

  /** Return the volume of this cylinder */
  public double findVolume() {
    return super.findArea() * length;
  }

  /** Override the toString method */
  public String toString() {
    return "This is a cylinder";
  }
}
