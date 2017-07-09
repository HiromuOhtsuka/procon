import java.util.Scanner;

public class Main{
  static final long MOD = 1_000_000_007;
  static int t, l, r;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt();
    l = sc.nextInt();
    r = sc.nextInt();

    int[] table = new int[Math.max(l, r) + 1];
    for(int i = 2; i < table.length; i++){
      if(table[i] == 0){
        for(int j = 2; (long)j * (long)i < (long)table.length; j++){
          table[j * i] = i;
        }
      }
    }

    long[] fact = new long[Math.max(l, r) + 1];
    fact[0] = 1;
    for(int i = 1; i < fact.length; i++){
      fact[i] = (fact[i - 1] * (long)i) % MOD;
    }
    long inv = pow(2, MOD - 2);

    long[] f = new long[Math.max(l, r) + 1];
    f[2] = 1;
    for(int i = 3; i < f.length; i++){
      if(table[i] != 0){
        int m = i / table[i];
        int d = table[i];
        f[i] = ((((long)d * f[m]) % MOD) + f[d]) % MOD;
      }
      else{
        f[i] = ((((long)i * (long)(i - 1)) % MOD) * inv) % MOD;
      }
    }

    long sum = 0;
    long p = 1;
    for(int i = l; i <= r; i++){
      sum = (sum + ((p * f[i]) % MOD)) % MOD;
      p = (p * (long)t) % MOD;
    }

    System.out.println(sum);
  }

  static long pow(long a, long b){
    long base = a;
    long result = 1;
    for(int i = 0; i < 64; i++){
      if((b & (1L << i)) != 0L){
        result = (result * base) % MOD;
      }
      base = (base * base) % MOD;
    }
    return result;
  }
}

