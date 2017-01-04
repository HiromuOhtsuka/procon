import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.PriorityQueue;

public class Main {
  static int n, k;
  static int[] te;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); k = sc.nextInt();
    te = new int[n];
    for(int i = 0; i < n; i++){
      te[i] = sc.nextInt();
    }

    int count = 0;
    for(int i = 0; i < n; i++){
      if(te[i] < 0){
        ++count;
      }
    }

    if(count == 0){
      System.out.println(0);
      return;
    }

    if(count > k){
      System.out.println(-1);
      return;
    }

    k -= count;

    int segc = 0;
    if(te[0] < 0){
      ++segc;
    }
    for(int i = 1; i < n; i++){
      if(te[i - 1] >= 0 && te[i] < 0){
        ++segc;
      }
    }

    int ans = segc * 2;

    int s = 0;
    while(te[s] >= 0){
      ++s;
    }
    while(s < n && te[s] < 0){
      ++s;
    }

    PriorityQueue< Integer > pq = new PriorityQueue< >();
    while(s < n){
      int t = s + 1;
      while(t < n && te[t] >= 0){
        ++t;
      }
      if(t != n){
        pq.add((t - s));
      }
      while(t < n && te[t] < 0){
        ++t;
      }
      s = t;
    }

    while(!pq.isEmpty() && k - pq.peek() >= 0){
      k -= pq.poll();
      ans -= 2;
    }

    int t = n - 1;
    while(t >= 0 && te[t] >= 0){
      --t;
    }

    if(n - t - 1 <= k){
      --ans;
    }

    System.out.println(ans);
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
