import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n, m, k;
  static int[] c;
  static List< List< Integer > > G;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
    c = new int[k];
    for(int i = 0; i < k; i++){
      c[i] = sc.nextInt() - 1;
    }
    G = new ArrayList< List< Integer > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Integer >());
    }
    for(int i = 0; i < m; i++){
      int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
      G.get(u).add(v);  G.get(v).add(u);
    }

    long[] cn = new long[k];
    boolean[] visited = new boolean[n];
    for(int i = 0; i < k; i++){
      cn[i] = dfs(c[i], visited);
    }

    long ans = 0, sn = 0, max = 0;
    for(int i = 0; i < k; i++){
      ans += cn[i] * (cn[i] - 1) / 2L;
      sn += cn[i];
      max = Math.max(max, cn[i]);
    }
    long r = n - sn;
    ans += r * max + r * (r - 1L) / 2L;
    ans -= (long)m;

    System.out.println(ans);
  }

  private static long dfs(int v, boolean[] visited){
    long sum = 0;
    visited[v] = true;
    for(int w : G.get(v)){
      if(!visited[w]){
        sum += dfs(w, visited);
      }
    }
    return sum + 1L;
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
