import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n, m, k;
  static long x, s;
  static long[] a, b, c, d;
  static Pair[] e;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
    x = sc.nextInt(); s = sc.nextInt();
    a = new long[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt();
    }
    b = new long[m];
    for(int i = 0; i < m; i++){
      b[i] = sc.nextInt();
    }
    c = new long[k];
    for(int i = 0; i < k; i++){
      c[i] = sc.nextInt();
    }
    d = new long[k];
    for(int i = 0; i < k; i++){
      d[i] = sc.nextInt();
    }

    Pair[] tmp = new Pair[k];
    for(int i = 0; i < k; i++){
      tmp[i] = new Pair(d[i], c[i]);
    }

    Arrays.sort(tmp);
    List< Pair > list = new ArrayList< Pair >(k);
    long c0 = 0;
    for(int i = 0; i < k; i++){
      if(c0 < tmp[i].t){
        list.add(tmp[i]);
        c0 = tmp[i].t;
      }
    }
    e = list.toArray(new Pair[list.size()]);

    long low = -1, high = INF;
    while(high - low > 1){
      long mid = (low + high) / 2L;
      if(greedy(mid)){
        high = mid;
      }
      else{
        low = mid;
      }
    }

    System.out.println(high);
  }

  private static boolean greedy(long y){
    // 1 only
    long potion = 0, mana = 0, time = x;
    for(int i = 0; i < m; i++){
      if(mana + b[i] <= s){
        mana += b[i];
        time = a[i];
        break;
      }
    }
    long r = n - potion;
    if(r * time <= y){
      return true;
    }

    // 2 only
    potion = 0; mana = 0; time = x;
    for(int i = k - 1; i >= 0; i--){
      if(mana + d[i] <= s){
        mana += d[i];
        potion += c[i];
        break;
      }
    }
    r = n - potion;
    if(r * time <= y){
      return true;
    }

    // 1 and 2
    for(int i = 0; i < m; i++){
      int j = upperBound(-1, e.length, s - b[i]);
      if(0 <= j && j < e.length && b[i] + e[j].s <= s){
        r = n - e[j].t;
        if(r * a[i] <= y){
          return true;
        }
      }
    }

    return false;
  }

  private static int upperBound(int low, int high, long tar){
    while(high - low > 1){
      int mid = (high + low) / 2;
      if(e[mid].s <= tar){
        low = mid;
      }
      else{
        high = mid;
      }
    }
    return low;
  }

  static class Pair implements Comparable< Pair > {
    long s, t;

    Pair(long s, long t){
      this.s = s; this.t = t;
    }

    @Override
      public int compareTo(Pair p){
        if(s == p.s){
          return Long.compare(t, p.t);
        }
        return Long.compare(s, p.s);
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
