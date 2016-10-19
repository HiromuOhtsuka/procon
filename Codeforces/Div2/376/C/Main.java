import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Main {
  static int n, m, k;
  static int[] c;
  static List< List< Integer > > G;

  static int[] cmp;
  static int cc;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
    c = new int[n];
    for(int i = 0; i < n; i++){
      c[i] = sc.nextInt() - 1;
    }

    G = new ArrayList< List< Integer > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Integer >());
    }

    for(int i = 0; i < m; i++){
      int l = sc.nextInt() - 1, r = sc.nextInt() - 1;
      G.get(l).add(r);  G.get(r).add(l);
    }

    cmp = new int[n];
    Arrays.fill(cmp, -1);

    int sum = 0;
    for(int s = 0; s < n; s++){
      if(cmp[s] == -1){
        Map< Integer, Integer > count = new HashMap< Integer, Integer >();
        int size = dfs(s, count), max = 0;
        for(Map.Entry< Integer, Integer > e : count.entrySet()){
          max = Math.max(max, e.getValue());
        }
        sum += size - max;
        ++cc;
      }
    }

    System.out.println(sum);
  }

  private static int dfs(int v, Map< Integer, Integer > count){
    int size = 0;
    count.merge(c[v], 1, (ov, nv) -> {
        return ov + 1;
        });
    cmp[v] = cc;
    for(Integer w : G.get(v)){
      if(cmp[w] == -1){
        size += dfs(w, count);
      }
    }
    return size + 1;
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
