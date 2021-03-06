import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Arrays;

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

    int s = 0, t = 0, count = 0;
    int max = 0, maxs = -1, maxt = -1;
    while(s < n && t < n){
      while(t < n && count < k){
        if(a[t] == 0){
          ++count;
        }
        ++t;
      }
      while(t < n && a[t] == 1){
        ++t;
      }
      if(max < t - s){
        max = t - s;
        maxs = s; maxt = t;
      }
      if(a[s] == 0){
        --count;
      }
      ++s;
    }

    int[] ans = Arrays.copyOf(a, n);
    for(int i = maxs; i < maxt; i++){
      ans[i] = 1;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(max + "\n");
    for(int i = 0; i < n; i++){
      sb.append(ans[i] + ((i == n - 1) ? "\n" : " "));
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
