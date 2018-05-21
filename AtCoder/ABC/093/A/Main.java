import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.*;

public class Main{
  static final boolean DEBUG = true;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    String s = sc.next();

    boolean all = true;
    for(char ch = 'a'; ch <= 'c'; ch++){
      boolean exist = false;
      for(int j = 0; j < 3; j++){
        if(ch == s.charAt(j)){
          exist = true;
          break;
        }
      }
      if(!exist){
        all = false;
        break;
      }
    }

    if(all) System.out.println("Yes");
    else System.out.println("No");
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
