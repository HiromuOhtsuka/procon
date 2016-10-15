import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.Arrays;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int[] pos = new int[n + 1];
    for(int i = 0; i < n; i++){
      pos[a[i]] = i;
    }

    // left most right
    int[] lmr = new int[n];
    for(int i = 0; i < n; i++){
      int j = i - 1;
      while(j != -1 && a[j] > a[i]){
        j = lmr[j];
      }
      lmr[i] = j;
    }

    // right most left
    int[] rml = new int[n];
    for(int i = n - 1; i >= 0; i--){
      int j = i + 1;
      while(j != n && a[i] < a[j]){
        j = rml[j];
      }
      rml[i] = j;
    }

    int[] left = new int[n + 1];
    left[1] = pos[1];
    for(int i = 2; i <= n; i++){
      if(lmr[pos[i]] < pos[i]){
        left[i] = pos[i] - lmr[pos[i]] - 1;
      }
      else{
        left[i] = pos[i];
      }
    }

    int[] right = new int[n + 1];
    int ml = pos[1];
    right[1] = n - pos[1];
    for(int i = 2; i <= n; i++){
      if(pos[i] < rml[pos[i]]){
        right[i] = rml[pos[i]] - pos[i];
      }
      else{
        right[i] = n - pos[i];
      }
    }

    long sum = 0;
    for(int i = 1; i <= n; i++){
      sum += (long)i * ((long)right[i] * left[i] + right[i]);
    }

    System.out.println(sum);
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
