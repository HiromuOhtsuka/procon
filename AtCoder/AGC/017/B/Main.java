import java.util.Scanner;

public class Main{
  static long n;
  static long a, b, c, d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();
    d = sc.nextInt();

    long diff = Math.abs(a - b);
    for(long i = 0; i < n - 1; i++){
      if(c * (n - i - 1) - d * i <= diff &&
        diff <= d * (n - i - 1)  - c * i){
        System.out.println("YES");
        return;
      }
    }

    System.out.println("NO");
  }
}
