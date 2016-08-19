import java.util.Scanner;

public class Main {
  static int n;
  static int a, b, c, d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt();
    c = sc.nextInt(); d = sc.nextInt();

    long count = 0;
    for(int f = 1; f <= n; f++){
      if(1 <= b + f - c &&  b + f - c <= n &&
         1 <= a + f - d && a + f - d <= n &&
         1 <= (a + b + f) - (c + d) &&
         (a + b + f) - (c + d) <= n){
        ++count;
      }
    }

    System.out.println((long)n * count);
  }
}
