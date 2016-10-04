import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
  static int n;
  static List< List< Edge > > T;
  static int[] dist;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    T = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      T.add(new ArrayList< Edge >());
    }
    for(int i = 0; i < n - 1; i++){
      int s = sc.nextInt(), t = sc.nextInt(), w = sc.nextInt();
      T.get(s).add(new Edge(s, t, w)); T.get(t).add(new Edge(t, s, w));
    }

    dist = new int[n];
    dfs(0, -1, 0);

    int max = -1, maxv = -1;
    for(int i = 0; i < n; i++){
      if(max < dist[i]){
        max = dist[i];  maxv = i;
      }
    }

    Arrays.fill(dist, 0);
    dfs(maxv, -1, 0);

    max = -1;
    for(int i = 0; i < n; i++){
      max = Math.max(max, dist[i]);
    }

    System.out.println(max);
  }

  private static void dfs(int v, int p, int d){
    Stack< E > stack = new Stack< E >();
    stack.push(new E(v, p, d));
    while(!stack.isEmpty()){
      E ee = stack.pop();
      dist[ee.v] = ee.d;
      for(Edge e : T.get(ee.v)){
        if(e.w != ee.p){
          stack.push(new E(e.w, ee.v, ee.d + e.d));
        }
      }
    }
  }

  static class E {
    int v, p, d;

    E(int v, int p, int d){
      this.v = v; this.p = p; this.d = d;
    }
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
