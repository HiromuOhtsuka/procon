import java.util.Scanner;

public class Main{
  static final long MOD = 1_000_000_007;
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    long ans = 1;
    for(int i = 1; i <= n; i++){
      ans = (ans * (long)i) % MOD;
    }

    System.out.println(ans);
  }
}
