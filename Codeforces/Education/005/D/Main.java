import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int n, k;
  static int[] a;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); k = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    Map< Integer, Integer > counts = new TreeMap< Integer, Integer >();
    int s = 0, t = 0, kind = 0, max = 0, l = 0, r = 0;
    for(;;){
      while(t < n && kind <= k){
        if(counts.containsKey(a[t])){
          int c = counts.get(a[t]);
          counts.put(a[t], c + 1);
        }
        else{
          counts.put(a[t], 1);
          ++kind;
        }
        ++t;
      }

      if(t == n && kind <= k){
        t++;
      }

      if(max < (t - s)){
        max = t - s;
        l = s + 1;  r = t - 1;
      }

      if(t >= n){
        break;
      }

      int c = counts.get(a[s]);
      if(c == 1){
        counts.remove(a[s]);
        --kind;
      }
      else{
        counts.put(a[s], c - 1);
      }
      ++s;
    }

    System.out.println(l + " " + r);
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
