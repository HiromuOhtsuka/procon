import java.util.Scanner;

public class Main {
  static int a, b, c, k, s, t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();  b = sc.nextInt();
    c = sc.nextInt();  k = sc.nextInt();
    s = sc.nextInt();  t = sc.nextInt();

    int sum = (a * s + b * t);
    if((s + t) >= k){
      sum -= (s + t) * c;
    }

    System.out.println(sum);
  }
}
