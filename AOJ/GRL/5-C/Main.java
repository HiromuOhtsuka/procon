import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
  static int n, q;
  static List< List< Integer > > T;
  static int[] u, v;

  static int[] depth;
  static int[][] parent;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    T = new ArrayList< List< Integer > >(n);
    for(int i = 0; i < n; i++){
      T.add(new ArrayList< Integer >());
    }
    for(int i = 0; i < n; i++){
      int k = sc.nextInt();
      for(int j = 0; j < k; j++){
        int c = sc.nextInt();
        T.get(i).add(c); T.get(c).add(i);
      }
    }
    q = sc.nextInt();
    u = new int[q]; v = new int[q];
    for(int i = 0; i < q; i++){
      u[i] = sc.nextInt();  v[i] = sc.nextInt();
    }

    depth = new int[n];
    int[] par = new int[n];
    dfs(0, -1, 0, par);

    parent = new int[n][20];
    for(int v = 0; v < n; v++){
      parent[v][0] = par[v];
    }
    for(int v = 0; v < n; v++){
      for(int i = 1; i < parent[v].length; i++){
        if(parent[v][i - 1] == -1){
          parent[v][i] = -1;
        }
        else{
          parent[v][i] = parent[parent[v][i - 1]][i - 1];
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < q; i++){
      int ans = lca(u[i], v[i]);
      sb.append(ans + System.lineSeparator());
    }

    System.out.print(sb);
  }

  private static int lca(int u, int v){
    if(depth[u] > depth[v]){
      int tmp = u;  u = v;  v = tmp;
    }

    for(int i = 19; i >= 0; i--){
      if((((depth[v] - depth[u]) >> i) & 1) != 0){
        v = parent[v][i];
      }
    }

    if(u == v){
      return u;
    }

    for(int i = 19; i >= 0; i--){
      if(parent[u][i] != parent[v][i]){
        u = parent[u][i]; v = parent[v][i];
      }
    }

    return parent[u][0];
  }

  private static void dfs(int v, int p, int d, int[] par){
    Stack< E > stack = new Stack< E >();
    stack.push(new E(v, p, d));
    while(!stack.isEmpty()){
      E e = stack.pop();
      depth[e.v] = e.d;
      par[e.v] = e.p;
      for(Integer w : T.get(e.v)){
        if(w != e.p){
          stack.push(new E(w, e.v, e.d + 1));
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
