import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  static int n;
  static int[] y;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    y = new int[n];
    for(int i = 0; i < n; i++){
      y[i] = sc.nextInt();
    }

    Map< Integer, Integer > position = new TreeMap< Integer, Integer >();
    for(int i = 0; i < n; i++){
      position.put(y[i], i);
    }

    TreeSet< Integer > set = new TreeSet< Integer >();
    for(int i = 0; i < n; i++){
      set.add(y[i]);
    }

    boolean has = true;
    while(has){
      int max = set.last();
      int tmp = max;
      while(tmp >= 1 && has){
        if(!set.contains(tmp)){
          has = false;  break;
        }
        tmp /= 2;
      }
      if(tmp == 0){
        has = false;
      }
      else if(!has){
        set.remove(max);  set.add(tmp);
        y[position.get(max)] = tmp;
        position.put(tmp, position.get(max));
        position.remove(max);
        has = true;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      sb.append(y[i] + (i == n - 1 ? "\n" : " "));
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
