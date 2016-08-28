import java.util.Scanner;

public class Main {
  static int n, k, x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    x = sc.nextInt(); y = sc.nextInt();

    int sum = 0;
    if(n <= k){
      sum += n * x;
      System.out.println(sum);
      return;
    }

    sum += k * x;
    sum += y * (n - k);

    System.out.println(sum);
  }
}
