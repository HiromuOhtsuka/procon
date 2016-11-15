import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int n, m;
  static int[] d, a;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt();
    d = new int[n];
    for(int i = 0; i < n; i++){
      d[i] = sc.nextInt();
    }
    a = new int[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt();
    }

    int low = -1, high = n;
    while(high - low > 1){
      int mid = (low + high) / 2;
      if(f(mid)){
        high = mid;
      }
      else{
        low = mid;
      }
    }

    int ans = -1;
    if(high != n){
      ans = high + 1;
    }

    System.out.println(ans);
  }

  private static boolean f(int k){
    int need = 0;
    boolean[] flag = new boolean[m];

    for(int i = k; i >= 0; i--){
      if(need > 0 && (d[i] == 0 || flag[d[i] - 1])){
        --need;
      }
      else if(d[i] != 0 && !flag[d[i] - 1]){
        need += a[d[i] - 1];
        flag[d[i] - 1] = true;
      }
    }

    if(need != 0){
      return false;
    }

    for(int i = 0; i < m; i++){
      if(!flag[i]){
        return false;
      }
    }

    return true;
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
