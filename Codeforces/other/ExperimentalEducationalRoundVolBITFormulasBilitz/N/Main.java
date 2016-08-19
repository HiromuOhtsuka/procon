import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    double a = scan.nextDouble(), b = scan.nextDouble(), c = scan.nextDouble();
    double x0 = (- b + Math.sqrt(b * b - 4 * a * c)) / (2 * a),
           x1 = (- b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    System.out.printf("%6f%n%6f%n", Math.max(x0, x1), Math.min(x0, x1));
  }
}
