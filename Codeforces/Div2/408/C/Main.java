import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static int[] a;
  static List< List< Integer > > G;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    G = new ArrayList< >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< >());
    }
    for(int i = 0; i < n - 1; i++){
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      G.get(u).add(v);
      G.get(v).add(u);
    }

    int max = -INF;
    for(int i = 0; i < n; i++){
      max = Math.max(max, a[i]);
    }

    for(int i = 0; i < n; i++){
      a[i] += 2;
    }

    TreeMap< Integer, Integer > map = new TreeMap< >();
    for(int i = 0; i < n; i++){
      if(a[i] == max + 1 || a[i] == max + 2){
        add(map, a[i]);
      }
    }

    int min = INF;
    for(int v = 0; v < n; v++){
      if(a[v] == max + 1 || a[v] == max + 2){
        update(map, a[v], a[v] - 2);
      }
      for(int w : G.get(v)){
        if(a[w] == max + 1 || a[w] == max + 2){
          update(map, a[w], a[w] - 1);
        }
      }
      min = Math.min(min, map.lastEntry().getKey());

      if(a[v] == max + 1 || a[v] == max + 2){
        update(map, a[v] - 2, a[v]);
      }
      for(int w : G.get(v)){
        if(a[w] == max + 1 || a[w] == max + 2){
          update(map, a[w] - 1, a[w]);
        }
      }
    }

    System.out.println(min);
  }

  private static void add(TreeMap< Integer, Integer > map, int value){
    if(map.containsKey(value)){
      map.put(value, map.get(value) + 1);
    }
    else{
      map.put(value, 1);
    }
  }

  private static void update(TreeMap< Integer, Integer > map, int value0, int value1){
    if(map.containsKey(value0)){
      if(map.get(value0) == 1){
        map.remove(value0);
      }
      else{
        map.put(value0, map.get(value0) - 1);
      }
    }
    add(map, value1);
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
