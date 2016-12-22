import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;

public class Main {
  static final long INF = Long.MAX_VALUE / 2L;
  static int n;
  static long[] a;
  static List< List< Integer > > G;
  static long[] sum;
  static long max = -INF;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextLong();
    }
    G = new ArrayList< List< Integer > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Integer >());
    }
    for(int i = 0; i < n - 1; i++){
      int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
      G.get(u).add(v);  G.get(v).add(u);
    }

    if(n == 1){
      System.out.println("Impossible");
      return;
    }

    sum = new long[n];
    dfs(0, -1);

    if(max != -INF){
      System.out.println(max);
    }
    else{
      System.out.println("Impossible");
    }
  }

  private static long dfs(int v, int p){
    long max1 = -INF, max2 = -INF;
    for(int w : G.get(v)){
      if(w != p){
        long tmp = dfs(w, v);
        sum[v] += sum[w];
        if(max1 < tmp){
          max2 = max1;
          max1 = tmp;
        }
        else if(max2 < tmp){
          max2 = tmp;
        }
      }
    }
    sum[v] += a[v];
    if(max2 != -INF){
      max = Math.max(max, max1 + max2);
    }
    return Math.max(max1, sum[v]);
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
