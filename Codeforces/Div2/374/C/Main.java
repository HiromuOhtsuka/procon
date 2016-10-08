import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, m;
  static long T;
  static List< List< Edge > > R;

  static int[] bestPath;
  static int best;
  static int[][] pre;
  static int[][] dp;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt();
    T = sc.nextInt();
    R = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      R.add(new ArrayList< Edge >());
    }
    for(int i = 0; i < m; i++){
      int v = sc.nextInt() - 1, w = sc.nextInt() - 1, d = sc.nextInt();
      R.get(w).add(new Edge(w, v, d));
    }

    dp = new int[n][n + 1];
    pre = new int[n][n + 1];
    pre[0][1] = -1;
    for(int i = 0; i < n; i++){
      Arrays.fill(dp[i], -1);
    }

    int best = -1;
    for(int i = n; i >= 1; i--){
      if(opt(n - 1, i, 0, n - 1) <= T){
        best = i; break;
      }
    }

    bestPath = new int[best];
    int sp = 0, count = best + 1;
    for(int i = n - 1; i != -1; i = pre[i][count]){
      bestPath[sp++] = i;
      --count;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(best + System.lineSeparator());
    for(int i = best - 1; i >= 0; i--){
      sb.append((bestPath[i] + 1) + ((i == 0 ? "\n" : " ")));
    }

    System.out.print(sb);
  }

  static int opt(int v, int c, int s, int t){
    if(c <= 0){
      return -1;
    }

    if(dp[v][c] >= 0){
      return dp[v][c];
    }

    if(v == s){
      return dp[v][c] = (c == 1 ? 0 : -1);
    }

    int min = INF;
    for(Edge e : R.get(v)){
      int time = opt(e.w, c - 1, s, t);
      if(time >= 0){
        time += e.d;
        if(min > time){
          min = time; pre[v][c] = e.w;
        }
      }
    }

    return dp[v][c] = min;
  }

  static class Edge {
    int v, w, d;

    Edge(int v, int w, int d){
      this.v = v; this.w = w;
      this.d = d;
    }
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
