import java.util.Scanner;
import java.math.BigInteger;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n;
  static long[] t, a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    t = new long[n]; a = new long[n];
    for(int i = 0; i < n; i++){
      t[i] = sc.nextInt();  a[i] = sc.nextInt();
    }

    long tc = t[0], ac = a[0];
    for(int i = 1; i < n; i++){
      long d = binarySearch(t[i], a[i], ac, tc);
      ac += d;
      if(ac % a[i] != 0){
        ac = ((long)(ac / a[i]) + 1) * a[i];
      }
      tc = t[i] * (ac / a[i]);
    }

    long sum = (tc + ac);
    System.out.println(sum);
  }

  private static long binarySearch(long T, long A, long ac, long tc){
    long low = -1L, high = INF;
    while(high - low > 1L){
      long mid = (high + low) / 2L;
      if(f(mid, T, A, ac, tc)){
        high = mid;
      }
      else{
        low = mid;
      }
    }
    return high;
  }

  private static boolean f(long d, long T, long A, long a, long t){
    BigInteger db = new BigInteger(Long.toString(d)),
      Tb = new BigInteger(Long.toString(T)),
      Ab = new BigInteger(Long.toString(A)),  ab = new BigInteger(Long.toString(a)),
      tb = new BigInteger(Long.toString(t));
    BigInteger val = Tb.multiply(ab.add(db)).subtract(Ab.multiply(tb));
    return val.compareTo(new BigInteger("0")) >= 0;
  }
}
