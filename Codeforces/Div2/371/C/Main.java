import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int t;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    t = sc.nextInt();
    TryTree trt = new TryTree(19);
    StringBuilder ans = new StringBuilder();
    for(int i = 0; i < t; i++){
      char op = sc.next().charAt(0);
      long key = 0;
      switch(op){
        case '+':
          key = sc.nextLong();
          trt.add(key);
          break;
        case '-':
          key = sc.nextLong();
          trt.remove(key);
          break;
        case '?':
          String s = sc.next();
          int count = trt.get(s);
          ans.append(count);  ans.append(System.lineSeparator());
      }
    }

    System.out.print(ans);
  }
}

class TryTree {
  int depth;
  Node root;

  TryTree(int depth){
    this.depth = depth;
    this.root = init(0);
  }

  Node init(int d){
    if(d == depth){
      return null;
    }
    Node node = new Node(null, null, 0);
    node.l = init(d + 1); node.r = init(d + 1);
    return node;
  }

  void add(long key){
    Node cur = root;
    do{
      long d = key % 10L;
      if(d % 2L == 0){
        cur = cur.l;
      }
      else{
        cur = cur.r;
      }
      key /= 10L;
    }while(key != 0L);

    while(cur.l != null){
      cur = cur.l;
    }
    cur.val++;
  }

  void remove(long key){
    Node cur = root;
    do{
      long d = key % 10L;
      if(d % 2L == 0){
        cur = cur.l;
      }
      else{
        cur = cur.r;
      }
      key /= 10L;
    }while(key != 0L);

    while(cur.l != null){
      cur = cur.l;
    }
    cur.val--;
  }

  int get(String ptr){
    if(ptr.length() < 18){
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < 18 - ptr.length(); i++){
        sb.append("0");
      }
      sb.append(ptr);
      ptr = sb.toString();
    }

    assert(ptr.length() == 18);

    Node cur = root;
    for(int i = ptr.length() - 1; i >= 0; i--){
      char ch = ptr.charAt(i);
      if(ch == '0'){
        cur = cur.l;
      }
      else{
        cur = cur.r;
      }
    }

    return cur.val;
  }

  class Node {
    int val;
    Node l, r;  // l:0(even), r:1(odd)

    Node(Node l, Node r, int val){
      this.l = l; this.r = r;
      this.val = val;
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
