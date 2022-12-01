public class Main2 {
  public static void main(String[] args) {
    int x = 24;
    int y = 8;

    y = x * y ; // x = 2, y = 16
    x = y/x; // x = 8, y = 16
    y = y/x;

    System.out.println("x: " + x);
    System.out.println("y: " + y);
  }
}
