import java.util.Set;
import java.util.HashSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main{
  static int n, m, k;
  static int[] h;
  static int[] u, v;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    h = new int[m];
    for(int i = 0; i < m; i++){
      h[i] = sc.nextInt() - 1;
    }
    u = new int[k];
    v = new int[k];
    for(int i = 0; i < k; i++){
      u[i] = sc.nextInt() - 1;
      v[i] = sc.nextInt() - 1;
    }

    Set< Integer > holes = new HashSet< >();
    for(int i = 0; i < m; i++){
      holes.add(h[i]);
    }

    if(holes.contains(0)){
      System.out.println(1);
      return;
    }

    int at = 0;
    for(int i = 0; i < k; i++){
      if(u[i] == at){
        at = v[i];
        if(holes.contains(v[i])){
          break;
        }
      }
      else if(v[i] == at){
        at = u[i];
        if(holes.contains(u[i])){
          break;
        }
      }
    }

    System.out.println(at + 1);
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
