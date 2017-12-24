import java.util.Scanner;
import java.math.BigInteger;

public class Main{
  static long r, b, x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    r = sc.nextLong();
    b = sc.nextLong();
    x = sc.nextLong();
    y = sc.nextLong();

    long low = 0, high = Math.max(r, b);
    while(high - low > 1){
      long mid = (low + high) / 2;
      if(f(mid)){
        low = mid;
      }
      else{
        high = mid;
      }
    }

    System.out.println(low);
  }

  static boolean f(long k){
    BigInteger b0 = new BigInteger("0");
    BigInteger b1 = new BigInteger("1");
    BigInteger kb = new BigInteger(Long.toString(k));
    BigInteger rb = new BigInteger(Long.toString(r));
    BigInteger bb = new BigInteger(Long.toString(b));
    BigInteger xb = new BigInteger(Long.toString(x));
    BigInteger yb = new BigInteger(Long.toString(y));
    BigInteger tmp1 = rb.subtract(kb).divide(xb.subtract(b1));
    BigInteger tmp2 = bb.subtract(yb.multiply(kb)).divide(b1.subtract(yb));
    if(tmp1.compareTo(b0) < 0) return false;
    if(tmp2.compareTo(kb) > 0) return false;
    return tmp2.compareTo(tmp1) <= 0;
  }
}
