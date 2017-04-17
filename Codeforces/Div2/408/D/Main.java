import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, k, d;
  static int[] p;
  static List< List< Integer > > G;

  static final boolean DEBUG = false;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    k = sc.nextInt();
    d = sc.nextInt();
    p = new int[k];
    for(int i = 0; i < k; i++){
      p[i] = sc.nextInt() - 1;
    }
    G = new ArrayList< >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< >());
    }
    int[][] edges = new int[n - 1][2];
    for(int i = 0; i < n - 1; i++){
      int v = sc.nextInt() - 1;
      int w = sc.nextInt() - 1;
      edges[i][0] = v;
      edges[i][1] = w;
      G.get(v).add(w);
      G.get(w).add(v);
    }

    boolean[] isP = new boolean[n];
    for(int i = 0; i < k; i++){
      isP[p[i]] = true;
    }

    int[] minV = new int[n];
    int[] dist = new int[n];
    Arrays.fill(dist, INF);
    for(int i = 0; i < k; i++){
      dist[p[i]] = 0;
      minV[p[i]] = p[i];
    }
    Set< Integer > ps = new HashSet< >();
    for(int i = 0; i < k; i++){
      ps.add(p[i]);
    }
    Queue< Integer > queue = new LinkedList< >();
    for(int s : ps){
      queue.offer(s);
    }
    while(!queue.isEmpty()){
      int v = queue.poll();
      for(int w : G.get(v)){
        if(!isP[w] && 
            dist[v] + 1 <= d && dist[v] + 1 < dist[w]){
          dist[w] = dist[v] + 1;
          minV[w] = minV[v];
          queue.offer(w);
        }
      }
    }

    if(DEBUG){
      for(int i = 0; i < n; i++){
        System.out.println(i + " : " + minV[i] + " : " + dist[i]);
      }
    }

    int count = 0;
    int[] removable = new int[n - 1];
    for(int i = 0; i < n - 1; i++){
      int v = edges[i][0];
      int w = edges[i][1];
      if(minV[v] != minV[w]){
        removable[count++] = i;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(count + System.lineSeparator());
    for(int i = 0; i < count; i++){
      sb.append(removable[i] + 1 + " ");
    }

    System.out.println(sb);
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
