import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    long n = scan.nextInt();
    long tmp = (n * (n - 1) * (n - 2) * (n - 3) * (n - 4)) / (5 * 4 * 3 * 2);
    long sum = tmp + (n - 5) * tmp / 6 + (n - 5) * (n - 6) * tmp / (6 * 7);

    System.out.println(sum);
  }
}
