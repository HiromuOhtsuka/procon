import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int n, m;
  static boolean[][] a;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt();
    a = new boolean[n][m];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        int v = sc.nextInt();
        a[i][j] = (v == 1);
      }
    }

    int count = 0;
    for(int i = 0; i < n; i++){
      boolean flag = false;
      for(int j = 0; j < m; j++){
        if(!a[i][j] && flag){
          ++count;
        }
        else if(a[i][j]){
          flag = true;
        }
      }
      flag = false;
      for(int j = m - 1; j >= 0; j--){
        if(!a[i][j] && flag){
          ++count;
        }
        else if(a[i][j]){
          flag = true;
        }
      }
    }
    for(int j = 0; j < m; j++){
      boolean flag = false;
      for(int i = 0; i < n; i++){
        if(!a[i][j] && flag){
          ++count;
        }
        else if(a[i][j]){
          flag = true;
        }
      }
      flag = false;
      for(int i = n - 1; i >= 0; i--){
        if(!a[i][j] && flag){
          ++count;
        }
        else if(a[i][j]){
          flag = true;
        }
      }
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
