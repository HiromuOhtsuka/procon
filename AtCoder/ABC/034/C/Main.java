import java.util.Scanner;

public class Main {
  static final long MOD = 1_000_000_007;

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    long w = scan.nextInt(), h = scan.nextInt();

    long whp = 1L;
    for(long i = 1; i <= w + h - 2; i++){
      whp = (whp * i) % MOD;
    }
    long wp = 1L;
    for(long i = 1; i <= w - 1; i++){
      wp = (wp * i) % MOD;
    }
    long hp = 1L;
    for(long i = 1; i <= h - 1; i++){
      hp = (hp * i) % MOD;
    }

    long wpr = 1L, base = wp, c = MOD - 2;
    do {
      if((c & 1L) != 0L){
        wpr = (wpr * base) % MOD;
      }
      base = (base * base) % MOD;
      c >>= 1L;
    } while(c != 0L);

    long hpr = 1L;
    base = hp; c = MOD - 2;
    do {
      if((c & 1L) != 0L){
        hpr = (hpr * base) % MOD;
      }
      base = (base * base) % MOD;
      c >>= 1L;
    } while(c != 0L);

    long ans = (((hpr * wpr) % MOD) * whp) % MOD;

    System.out.println(ans);
  }
}
