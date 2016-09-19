import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.Set;
import java.util.TreeSet;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n;
  static long[] a;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    Set< Long > diff = new TreeSet< Long >();
    for(int i = 0; i < n; i++){
      diff.add(a[i]);
    }

    long min = INF, max = -1;
    for(int i = 0; i < n; i++){
      min = Math.min(min, a[i]);  max = Math.max(max, a[i]);
    }

    long tar = (min + max) / 2L;
    boolean ans = true;
    long x = Math.abs(max - tar);
    for(int i = 0; i < n; i++){
      if(!(a[i] == tar || Math.abs(a[i] - tar) == x)){
        ans = false;  break;
      }
    }

    if(diff.size() <= 2 || ans){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
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
