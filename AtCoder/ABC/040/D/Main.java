import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Main {
  static int n, m, q;
  static List< Query > queries;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt();

    queries = new ArrayList< Query >(100000);
    for(int i = 0; i < m; i++){
      int a = sc.nextInt() - 1, b = sc.nextInt() - 1, y = sc.nextInt();
      queries.add(new Query(a, b, y, true));
    }

    q = sc.nextInt();
    for(int i = 0; i < q; i++){
      int v = sc.nextInt() - 1, w = sc.nextInt();
      queries.add(new Query(v, i, w, false));
    }

    Query[] queries2 =  queries.toArray(new Query[queries.size()]);

    Arrays.sort(queries2);
    UnionFindTree uf = new UnionFindTree(n);
    int[] ans = new int[q];
    for(Query query : queries2){
      if(query.isEdge){
        int v = query.v, w = query.w;
        uf.union(v, w);
      }
      else{
        ans[query.w] = uf.childCount(query.v);
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < q; i++){
      sb.append(ans[i] + "\n");
    }

    System.out.print(sb.toString());
  }

  static class Query implements Comparable< Query > {
    boolean isEdge;
    int v, w, y;

    Query(int v, int w, int y, boolean isEdge){
      this.v = v; this.w = w;
      this.y = y;
      this.isEdge = isEdge;
    }

    @Override
      public int compareTo(Query q){
        if(q.y == y){
          if(q.isEdge && !isEdge){
            return -1;
          }
          else if(!q.isEdge && isEdge){
            return 1;
          }
          else{
            return 0;
          }
        }
        return q.y - y;
      }
  }
}

class UnionFindTree {
  private int N;
  private int[] root, rank, child;

  public UnionFindTree(int n){
    this.N = n;
    this.root = new int[N];
    this.rank = new int[N];
    this.child = new int[N];
    for(int i = 0; i < root.length; i++){
      root[i] = i;
      child[i] = 1;
    }
  }

  public void union(int v, int w){
    int vr = root(v), wr = root(w);
    if(vr == wr){
      return;
    }
    int sum = child[vr] + child[wr];
    child[vr] = child[wr] = sum;
    if(rank[vr] < rank[wr]){
      root[vr] = wr;
    }
    else{
      root[wr] = vr;
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

  public int childCount(int v){
    return child[root(v)];
  }

  public boolean isSame(int v, int w){
    return root(v) == root(w);
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
