import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    int[] ans = new int[14];
    for(int k = 1; k < 14; k++){
      int mm = k;
      for(;;){
        boolean flag = false;
        for(int i = 0; i < k; i++){
          int m = mm + i;
          int n = 2 * k, cur = -1;
          boolean ok = true;
          while(n != k){
            cur = (cur + m) % n;
            if(cur < k){
              ok = false;  break;
            }
            cur = (cur - 1) % n;
            --n;
          }

          if(ok){
            ans[k] = m;
            flag = true;
            break;
          }
        }

        if(flag){
          break;
        }

        mm += k;
      }
    }

    StringBuilder sb = new StringBuilder();
    while(sc.hasNext()){
      int k = sc.nextInt();

      if(k == 0){
        break;
      }

      sb.append(ans[k] + "\n");
    }

    System.out.print(sb);
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
