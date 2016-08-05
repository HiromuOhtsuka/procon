import java.util.Scanner;

public class Main {
  static final long MOD = 10007;
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    if(n <= 2){
      System.out.println(0);
      return;
    }

    long a1 = 0, a2 = 0, a3 = 1;
    for(int i = 4; i <= n; i++){
      long a = (a1 + a2 + a3) % MOD;
      a1 = a2; a2 = a3; a3 = a;
    }

    System.out.println(a3);
  }
}
