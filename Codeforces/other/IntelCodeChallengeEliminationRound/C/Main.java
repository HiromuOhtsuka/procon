import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int n;
  static int[] a, p;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    p = new int[n];
    for(int i = 0; i < n; i++){
      p[i] = sc.nextInt();
    }

    long[] sum = new long[n + 1];
    for(int i = 0; i < n; i++){
      sum[i + 1] = a[i];
    }

    long[] ans = new long[n];
    long max = 0;
    UnionFindTree uft = new UnionFindTree(n + 1, sum);
    boolean[] alive = new boolean[n + 1];
    for(int i = n - 1; i >= 0; i--){
      ans[i] = max;
      int v = p[i] + 1, w = p[i] - 1;
      if(v <= n && alive[v]){
        uft.union(p[i], v);
      }
      if(w >= 1 && alive[w]){
        uft.union(p[i], w);
      }
      max = Math.max(max, uft.sum(p[i]));
      alive[p[i]] = true;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      sb.append(ans[i] + System.lineSeparator());
    }

    System.out.print(sb);
  }
}

class UnionFindTree {
  private int N;
  private int[] root, rank;
  private long[] sum;

  public UnionFindTree(int n, long[] sum){
    this.N = n;
    this.root = new int[N];
    this.rank = new int[N];
    this.sum = sum;
    for(int i = 0; i < root.length; i++){
      root[i] = i;
    }
  }

  public void union(int v, int w){
    int vr = root(v), wr = root(w);
    if(vr == wr){
      return;
    }
    if(rank[vr] < rank[wr]){
      root[vr] = wr;
      sum[wr] += sum[vr];
    }
    else{
      root[wr] = vr;
      sum[vr] += sum[wr];
      if(rank[vr] == rank[wr]){
        ++rank[vr];
      }
    }
  }

  public int root(int v){
    if(root[v] == v){
      return v;
    }
    return root[v] = root(root[v]);
  }

  public boolean isSame(int v, int w){
    return root(v) == root(w);
  }

  public long sum(int v){
    return sum[root(v)];
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
