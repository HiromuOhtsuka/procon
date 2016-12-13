import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

public class Main {
  static int n, x;
  static int[] a;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); x = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int[] b = new int[n];
    for(int i = 0; i < n; i++){
      b[i] = a[i] ^ x;
    }

    Map< Integer, Long > map = new TreeMap< Integer, Long >();
    for(int i = 0; i < n; i++){
      if(!map.containsKey(a[i])){
        map.put(a[i], 1L);
      }
      else{
        map.put(a[i], map.get(a[i]) + 1L);
      }
    }

    long count = 0;
    for(int i = 0; i < n; i++){
      if(map.containsKey(b[i])){
        count += map.get(b[i]);
        if(b[i] == a[i]){
          --count;
        }
      }
    }
    count /= 2L;

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
