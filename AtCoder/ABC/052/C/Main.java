import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static final long MOD = 1_000_000_007;
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    boolean[] prime = new boolean[n + 1];
    int count = 0;
    Arrays.fill(prime, true);
    prime[1] = false;
    for(int i = 2; i <= n; i++){
      if(prime[i]){
        for(int j = 2; j * i <= n; j++){
          prime[j * i] = false;
        }
        ++count;
      }
    }

    int[] primes = new int[count];
    int sp = 0;
    for(int i = 2; i <= n; i++){
      if(prime[i]){
        primes[sp++] = i;
      }
    }

    int[] expo = new int[n + 1];
    for(int i = 1; i <= n; i++){
      int m = i;
      for(int j = 0; j < primes.length; j++){
        int p = primes[j];
        while(p <= m && m % p == 0){
          m /= p;
          ++expo[p];
        }
      }
    }

    long ans = 1;
    for(int i = 2; i <= n; i++){
      ans = (ans * (expo[i] + 1)) % MOD;
    }

    System.out.println(ans);
  }
}
