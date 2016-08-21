import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int s = 0, t = 0;
    List< Pair > ans = new ArrayList< Pair >();
    Set< Integer > set = new TreeSet< Integer >();
    while(s < n){
      t = s;
      while(t < n && !set.contains(a[t])){
        set.add(a[t]);
        ++t;
      }
      if(t < n && set.contains(a[t])){
        ans.add(new Pair(s, t));
      }
      s = t + 1;
      set.clear();
    }

    if(ans.size() == 0){
      System.out.println(-1);
      return;
    }


    System.out.println(ans.size());
    for(int i = 0; i < ans.size() - 1; i++){
      Pair p = ans.get(i);
      System.out.println((p.s + 1) + " " + (p.t + 1));
    }
    Pair last = ans.get(ans.size() - 1);
    System.out.println((last.s + 1) + " " + n);
  }

  static class Pair {
    int s, t;

    Pair(int s, int t){
      this.s = s; this.t = t;
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
