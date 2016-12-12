import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static int n, k, l;
  static List< List< Integer > > GL, GT;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); k = sc.nextInt(); l = sc.nextInt();

    GL = new ArrayList< List< Integer > >(n);
    GT = new ArrayList< List< Integer > >(n);
    for(int i = 0; i < n; i++){
      GL.add(new ArrayList< Integer >());
      GT.add(new ArrayList< Integer >());
    }

    for(int i = 0; i < k; i++){
      int v = sc.nextInt() - 1, w = sc.nextInt() - 1;
      GL.get(v).add(w); GL.get(w).add(v);
    }
    for(int i = 0; i < l; i++){
      int v = sc.nextInt() - 1, w = sc.nextInt() - 1;
      GT.get(v).add(w); GT.get(w).add(v);
    }

    int[] al = new int[n], bt = new int[n];
    int count1 = 0, count2 = 0;
    for(int v = 0; v < n; v++){
      if(al[v] == 0){
        dfs(v, al, ++count1, GL);
      }
      if(bt[v] == 0){
        dfs(v, bt, ++count2, GT);
      }
    }

    Pair[] ps = new Pair[n];
    for(int v = 0; v < n; v++){
      ps[v] = new Pair(al[v], bt[v], v);
    }
    Arrays.sort(ps);

    Set< Integer > set = new TreeSet< Integer >();
    int s = 0, t = 0, count = 0;
    int[] ans = new int[n];
    for(int i = 0; i < n; i++){
      if(s == ps[i].a && t == ps[i].b){
        ++count;  set.add(ps[i].i);
      }
      else{
        for(int j : set){
          ans[j] = count;
        }
        s = ps[i].a;  t = ps[i].b;
        count = 1;
        set.clear();  set.add(ps[i].i);
      }
    }
    for(int j : set){
      ans[j] = count;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      sb.append(ans[i] + ((i == n - 1 ? System.lineSeparator() : " ")));
    }

    System.out.print(sb);
  }

  private static void dfs(int v, int[] a, int c,
      List< List< Integer > > G){
    a[v] = c;
    for(Integer w : G.get(v)){
      if(a[w] == 0){
        dfs(w, a, c, G);
      }
    }
  }

  static class Pair implements Comparable< Pair > {
    int a, b, i;

    Pair(int a, int b, int i){
      this.a = a; this.b = b;
      this.i = i;
    }

    @Override
      public int compareTo(Pair p){
        if(a == p.a){
          return b - p.b;
        }
        return a - p.a;
      }

    @Override
      public boolean equals(Object obj){
        if(!(obj instanceof Pair)){
          return false;
        }
        Pair p = (Pair)obj;
        return p.a == a && p.b == b && p.i == i;
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
