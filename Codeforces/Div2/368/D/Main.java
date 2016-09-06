import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.BitSet;
import java.util.Arrays;

public class Main {
  static int n, m, q;

  static Query[] queries;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt(); q = sc.nextInt();
    queries = new Query[q];
    for(int i = 0; i < q; i++){
      int t = sc.nextInt(), y = sc.nextInt() - 1;
      if(t == 1 || t == 2){
        int x = sc.nextInt() - 1;
        queries[i] = new Query(t, y, x);
      }
      else if(t == 4){
        queries[i] = new Query(t, y + 1);
      }
      else{
        queries[i] = new Query(t, y);
      }
    }

    StringBuilder sb = new StringBuilder();

    BitSet all = new BitSet(m);
    all.set(0, m);

    Data[] datas = new Data[q + 1];
    datas[0] = new Data(0, new BitSet[n]);
    for(int i = 0; i < n; i++){
      datas[0].cols[i] = new BitSet(m);
    }

    for(int i = 1; i <= q; i++){
      Query que = queries[i - 1];

      Data cur = new Data(
        datas[i - 1].sum, Arrays.copyOf(datas[i - 1].cols, datas[i - 1].cols.length));

      if(que.t == 1){
        if(!cur.cols[que.i].get(que.j)){
          cur.cols[que.i].set(que.j);
          ++cur.sum;
        }
      }
      else if(que.t == 2){
        if(cur.cols[que.i].get(que.j)){
          cur.cols[que.i].clear(que.j);
          --cur.sum;
        }
      }
      else if(que.t == 3){
        cur.sum -= cur.cols[que.i].cardinality();
        cur.cols[que.i].xor(all);
        cur.sum += cur.cols[que.i].cardinality();
      }
      else{
        cur = new Data(datas[que.i].sum, 
          Arrays.copyOf(datas[que.i].cols, datas[que.i].cols.length));
      }

      sb.append(cur.sum + "\n");

      datas[i] = new Data(cur.sum, Arrays.copyOf(cur.cols, cur.cols.length));
    }

    System.out.print(sb);
  }

  static class Query {
    int t;
    int i, j;

    Query(int t, int i, int j){
      this.t = t;
      this.i = i; this.j = j;
    }

    Query(int t, int i){
      this.t = t;
      this.i = i;
    }
  }

  static class Data {
    int sum;
    BitSet[] cols;

    Data(int sum, BitSet[] cols){
      this.sum = sum;
      this.cols = cols;
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
