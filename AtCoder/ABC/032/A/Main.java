import java.util.Scanner;

public class Main {
  static int a, b, n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt();
    n = sc.nextInt();

    int d = (a * b) / gcd(a, b);
    int i = 1;
    while(i * d < n){
      i++;
    }

    int ans = i * d;

    System.out.println(ans);
  }

  private static int gcd(int c, int d){
    if(c == 0){
      return d;
    }
    return gcd(d % c, c);
  }

}
