import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.Arrays;

public class Main {
  static int n, m;
  static int[] p, a, b;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt();
    p = new int[n];
    for(int i = 0; i < n; i++){
      p[i] = sc.nextInt();
    }
    a = new int[m]; b = new int[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt();  b[i] = sc.nextInt();
    }

    int[] pos = new int[n + 1];
    for(int i = 0; i < n; i++){
      pos[p[i]] = i;
    }

    int[] left = new int[n + 1];
    Arrays.fill(left, -1);
    for(int i = 0; i < m; i++){
      int x = pos[a[i]], y = pos[b[i]];
      if(x < y){
        left[b[i]] = Math.max(left[b[i]], x);
      }
      else{
        left[a[i]] = Math.max(left[a[i]], y);
      }
    }

    long count = 0;
    int s = 0, t = 0;
    while(s < n && t < n){
      if(left[p[t]] != -1){
        s = Math.max(s, left[p[t]] + 1);
      }
      count += t - s + 1;
      ++t;
    }

    System.out.println(count);
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
