import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.*;

public class Main{
  static char[] s;
  static int x, y;

  static final boolean DEBUG = false;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();
    s = sc.next().toCharArray();
    x = sc.nextInt(); y = sc.nextInt();

    List< Integer > ax = new ArrayList< >();
    List< Integer > ay = new ArrayList< >();
    boolean turn = true;
    int dx = 0, dy = 0;
    for(int i = 0; i < s.length; i++){
      if(s[i] == 'T'){
        if(turn) ax.add(dx);
        else ay.add(dy);
        turn = !turn;
        dx = dy = 0;
      }
      else if(turn) ++dx;
      else ++dy;
    }
    if(s[s.length - 1] != 'T'){
      if(turn) ax.add(dx);
      else ay.add(dy);
    }

    if(DEBUG){
      System.out.println(ax);
      System.out.println(ay);
    }

    Set< Integer > s0 = new HashSet< >();
    s0.add(ax.get(0));
    for(int i = 1; i < ax.size(); i++){
      Set< Integer > s1 = new HashSet< >();
      for(int xx: s0){
        s1.add(xx + ax.get(i));
        s1.add(xx - ax.get(i));
      }
      s0 = s1;
    }

    if(!s0.contains(x)){
      System.out.println("No");
      return;
    }

    s0.clear();
    s0.add(0);
    for(int i = 0; i < ay.size(); i++){
      Set< Integer > s1 = new HashSet< >();
      for(int yy: s0){
        s1.add(yy + ay.get(i));
        s1.add(yy - ay.get(i));
      }
      s0 = s1;
    }

    if(s0.contains(y)){
      System.out.println("Yes");
    }
    else{
      System.out.println("No");
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
