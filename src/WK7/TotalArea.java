package objects;

public class TotalArea {
  /** Main method */
  public static void main(String[] args) {
    // Declare circleArray
    Circle[] circleArray;

    // Create circleArray
    circleArray = createCircleArray();

    // Print circleArray and total areas of the circles
    printCircleArray(circleArray);
  }

  /** Create an array of Circle objects */
  public static Circle[] createCircleArray() {
    Circle[] circleArray = new Circle[10];

    for (int i = 0; i < circleArray.length; i++) {
      circleArray[i] = new Circle(Math.random() * 100);
    }

    // Return Circle array
    return circleArray;
  }

  /** Print an array of circles and their total area */
  public static void printCircleArray
      (Circle[] circleArray) {
    System.out.println("Radius\t\t\t\t" + "Area");
    for (int i = 0; i < circleArray.length; i++) {
      System.out.print(circleArray[i].getRadius() + "\t\t" +
        circleArray[i].findArea() + '\n');
    }

    System.out.println("-----------------------------------------");

    // Compute and display the result
    System.out.println("The total areas of circles is \t" +
      sum(circleArray));
  }

  /** Add circle areas */
  public static double sum(Circle[] circleArray) {
    // Initialize sum
    double sum = 0;

    // Add areas to sum
    for (int i = 0; i < circleArray.length; i++)
      sum += circleArray[i].findArea();

    return sum;
  }
}
