import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.*;

public class Main{
  static final boolean DEBUG = true;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    int sum = a + b + c;
    int m = Math.max(a, Math.max(b, c));
    int ans;
    if(sum % 2 == (3 * m) % 2){
      ans = ((3 * m) - sum) / 2;
    }
    else{
      ans = ((3 * (m + 1)) - sum) / 2;
    }

    System.out.println(ans);
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
