import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int m, k;
  static long n, x, s;
  static long[] a, b, c, d;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
    x = sc.nextInt(); s = sc.nextInt();
    a = new long[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt();
    }
    b = new long[m];
    for(int i = 0; i < m; i++){
      b[i] = sc.nextInt();
    }
    c = new long[k];
    for(int i = 0; i < k; i++){
      c[i] = sc.nextInt();
    }
    d = new long[k];
    for(int i = 0; i < k; i++){
      d[i] = sc.nextInt();
    }

    long ans = n * x;

    // 1 only
    long potion = 0;
    for(int i = 0; i < m; i++){
      if(b[i] <= s){
        ans = Math.min(ans, a[i] * n);
      }
    }

    // 2 only
    potion = 0;
    for(int i = k - 1; i >= 0; i--){
      if(d[i] <= s){
        ans = Math.min(ans, x * (n - c[i]));
      }
    }

    // 1 and 2
    for(int i = 0; i < m; i++){
      if(b[i] > s){
        continue;
      }
      long r = s - b[i];
      int low = -1, high = k;
      while(high - low > 1){
        int mid = (high + low) / 2;
        if(d[mid] <= r){
          low = mid;
        }
        else{
          high = mid;
        }
      }
      if(0 <= low && low < k){
        ans = Math.min(ans, a[i] * (n - c[low]));
      }
    }

    System.out.println(ans);
  }
}

class FastScanner {
  private static final InputStream in = System.in;
  private static final PrintWriter out = new PrintWriter(System.out);
  private final byte[] buffer = new byte[2048];
  private int p = 0;
  private int buflen = 0;

  public FastScanner(){
  }

  private boolean hasNextByte() {
    if(p < buflen){
      return true;
    }
    p = 0;
    try{
      buflen = in.read(buffer);
    }catch (IOException e) {
      e.printStackTrace();
    }
    if(buflen <= 0){
      return false;
    }
    return true;
  }

  public boolean hasNext() {
    while(hasNextByte() && !isPrint(buffer[p])){
      p++;
    }
    return hasNextByte();
  }

  private boolean isPrint(int ch) {
    if(ch >= '!' && ch <= '~'){
      return true;
    }
    return false;
  }

  private int nextByte() {
    if(!hasNextByte()){
      return -1;
    }
    return buffer[p++];
  }

  public String next() {
    if(!hasNext()){
      throw new NoSuchElementException();
    }
    StringBuilder sb = new StringBuilder();
    int b = -1;
    while(isPrint((b = nextByte()))){
      sb.appendCodePoint(b);
    }
    return sb.toString();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  public long nextLong() {
    return Long.parseLong(next());
  }

  public double nextDouble() {
    return Double.parseDouble(next());
  }
}
