import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int n, m;
  static int[] a, l, r, x;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    l = new int[m]; r = new int[m]; x = new int[m];
    for(int i = 0; i < m; i++){
      l[i] = sc.nextInt() - 1;  r[i] = sc.nextInt() - 1;
      x[i] = sc.nextInt();
    }

    int[] p = new int[n];
    p[0] = -1;
    for(int i = 1; i < n; i++){
      if(a[i - 1] != a[i]){
        p[i] = i - 1;
      }
      else{
        p[i] = p[i - 1];
      }
    }

    int[] ans = new int[m];
    for(int i = 0; i < m; i++){
      if(a[r[i]] != x[i]){
        ans[i] = r[i] + 1;
      }
      else if(p[r[i]] >= l[i]){
        ans[i] = p[r[i]] + 1;
      }
      else{
        ans[i] = -1;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < m; i++){
      sb.append(ans[i] + "\n");
    }

    System.out.print(sb.toString());
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
