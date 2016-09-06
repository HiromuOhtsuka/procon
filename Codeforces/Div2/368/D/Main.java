import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.BitSet;
import java.util.Arrays;

public class Main {
  static int n, m, q;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt(); q = sc.nextInt();

    BitSet all = new BitSet(m);
    all.set(0, m);

    BitSet[] rows = new BitSet[q + 1];
    for(int i = 0; i <= q; i++){
      rows[i] = new BitSet(m);
    }
    int[][] qi = new int[q + 1][n];
    int[] ans = new int[q + 1];

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= q; i++){
      int t = sc.nextInt(), x = sc.nextInt() - 1;
      ans[i] = ans[i - 1];

      if(t == 1){
        int y = sc.nextInt() - 1;
        qi[i] = Arrays.copyOf(qi[i - 1], n);
        int j = qi[i][x];
        rows[i] = (BitSet)rows[j].clone();
        if(!rows[i].get(y)){
          rows[i].set(y);
          ++ans[i];
        }
        qi[i][x] = i;
      }
      else if(t == 2){
        int y = sc.nextInt() - 1;
        qi[i] = Arrays.copyOf(qi[i - 1], n);
        int j = qi[i][x];
        rows[i] = (BitSet)rows[j].clone();
        if(rows[i].get(y)){
          rows[i].clear(y);
          --ans[i];
        }
        qi[i][x] = i;
      }
      else if(t == 3){
        qi[i] = Arrays.copyOf(qi[i - 1], n);
        int j = qi[i][x];
        rows[i] = (BitSet)rows[j].clone();
        ans[i] -= rows[i].cardinality();
        rows[i].xor(all);
        ans[i] += rows[i].cardinality();
        qi[i][x] = i;
      }
      else{
        ans[i] = ans[x + 1];
        qi[i] = Arrays.copyOf(qi[x + 1], n);
      }

      sb.append(ans[i] + "\n");
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
