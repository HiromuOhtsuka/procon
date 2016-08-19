import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    long n = scan.nextInt();
    long sum = 3 * n * (n + 1) + 1;
    
    System.out.println(sum);
  }
}
