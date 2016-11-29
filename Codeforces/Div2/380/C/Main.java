import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.Arrays;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, k, s, t;
  static int[] c, v, g;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); k = sc.nextInt();
    s = sc.nextInt(); t = sc.nextInt();
    c = new int[n]; v = new int[n];
    for(int i = 0; i < n; i++){
      c[i] = sc.nextInt();  v[i] = sc.nextInt();
    }
    g = new int[k + 1];
    for(int i = 0; i < k; i++){
      g[i] = sc.nextInt();
    }
    g[k] = s;
    Arrays.sort(g);

    int low = -1, high = INF;
    while(high - low > 1){
      int mid = (high + low) / 2;
      if(f(mid)){
        high = mid;
      }
      else{
        low = mid;
      }
    }

    int min = INF;
    for(int i = 0; i < n; i++){
      if(v[i] >= high){
        min = Math.min(min, c[i]);
      }
    }

    if(min != INF){
      System.out.println(min);
    }
    else{
      System.out.println(-1);
    }
  }

  private static boolean f(int x){
    int p = 0, time = 0;
    for(int i = 0; i < k + 1; i++){
      int d = g[i] - p;
      if(x - d < 0){
        return false;
      }
      int y = Math.min(x - d, d);
      time += y + 2 * (d - y);
      p = g[i];
    }

    return time <= t;
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
