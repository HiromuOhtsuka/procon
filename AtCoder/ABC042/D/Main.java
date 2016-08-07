import java.util.Scanner;

public class Main {
  static final long MOD = 1_000_000_007;
  static int h, w, a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    h = sc.nextInt();  w = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt();

    long[] xy = new long[w + h + 1];
    xy[0] = 1;
    for(int i = 1; i <= w + h; i++){
      xy[i] = (xy[i - 1] * (long)i) % MOD;
    }

    long[] xyr = new long[w + h + 1];
    for(int i = 0; i <= w + h; i++){
      long t = 1_000_000_005, tt = xy[i], ttt = 1;
      do{
        if((t & 1L) != 0){
          ttt = (ttt * tt) % MOD;
        }
        t >>= 1L;
        tt = (tt * tt) % MOD;
      }while(t != 0L);
      xyr[i] = ttt;
    }

    long[] ha = new long[w - b];
    for(int i = 0; i < ha.length; i++){
      ha[i] = (((xy[b + i + h - a - 1] * xyr[h - a - 1]) % MOD) * xyr[b + i]) % MOD;
    }

    long ans = 0;
    for(int i = 0; i < ha.length; i++){
      long tmp = (((xy[w - b - i - 1 + a - 1] * xyr[w - b - i - 1]) % MOD) * xyr[a - 1]) % MOD;
      ans = (ans + ((tmp * ha[i]) % MOD)) % MOD;
    }

    System.out.println(ans);
  }
}
