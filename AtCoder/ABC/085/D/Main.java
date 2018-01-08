import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.*;

public class Main{
  static int n;
  static long h;
  static int[] a, b;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();
    n = sc.nextInt();
    h = sc.nextInt();
    a = new int[n]; b = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();  b[i] = sc.nextInt();
    }

    Arrays.sort(a);
    Arrays.sort(b);

    int maxA = a[n - 1];

    int countB = 0;
    long sumB = 0;
    for(int i = n - 1; i >= 0; i--){
      if(maxA < b[i]){
        sumB += (long)b[i];
        ++countB;
        if(sumB >= h){
          System.out.println(countB);
          return;
        }
      }
    }

    long ans;
    if((h - sumB) % (long)maxA == 0){
      ans = (h - sumB) / (long)maxA + countB;
    }
    else{
      ans = (h - sumB) / (long)maxA + countB + 1;
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
