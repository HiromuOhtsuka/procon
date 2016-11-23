import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n;
  static long kx, ky;
  static char[] type;
  static long[] x, y;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    kx = sc.nextInt();  ky = sc.nextInt();
    type = new char[n];
    x = new long[n]; y = new long[n];
    for(int i = 0; i < n; i++){
      type[i] = sc.next().charAt(0);
      x[i] = sc.nextInt();  y[i] = sc.nextInt();
    }

    // horizonal
    List< Pair > tmp = new ArrayList< Pair >();
    for(int i = 0; i < n; i++){
      if(y[i] == ky){
        tmp.add(new Pair(x[i], i));
      }
    }
    Pair[] horizonal = tmp.toArray(new Pair[tmp.size()]);

    long leftMax = -INF;
    int left = -1, right = -1;
    long rightMin = INF;
    for(Pair p : horizonal){
      long cx = x[p.t], cy = y[p.t];
      if(cx < kx && leftMax < cx){
        leftMax = cx; left = p.t;
      }
      else if(cx > kx && rightMin > cx){
        rightMin = cx;  right = p.t;
      }
    }

    if(left != -1){
      if(type[left] == 'R' || type[left] == 'Q'){
        System.out.println("YES");
        return;
      }
    }
    if(right != -1){
      if(type[right] == 'R' || type[right] == 'Q'){
        System.out.println("YES");
        return;
      }
    }

    tmp.clear();

    // vertical
    for(int i = 0; i < n; i++){
      if(x[i] == kx){
        tmp.add(new Pair(y[i], i));
      }
    }
    Pair[] vertical = tmp.toArray(new Pair[tmp.size()]);

    long downMax = -INF;
    int down = -1, up = -1;
    long upMin = INF;
    for(Pair p : vertical){
      long cx = x[p.t], cy = y[p.t];
      if(cy < ky && cy > downMax){
        downMax = cy; down = p.t;
      }
      else if(cy > ky && cy < upMin){
        upMin = cy; up = p.t;
      }
    }

    if(down != -1){
      if(type[down] == 'R' || type[down] == 'Q'){
        System.out.println("YES");
        return;
      }
    }
    if(up != -1){
      if(type[up] == 'R' || type[up] == 'Q'){
        System.out.println("YES");
        return;
      }
    }

    tmp.clear();

    // right up
    for(int i = 0; i < n; i++){
      if(x[i] - kx == y[i] - ky){
        tmp.add(new Pair(x[i] - kx, i));
      }
    }
    Pair[] rightUp = tmp.toArray(new Pair[tmp.size()]);

    leftMax = -INF; left = -1;
    right = -1; rightMin = INF;
    for(Pair p : rightUp){
      long c = x[p.t] - kx;
      if(c > 0 && c < rightMin){
        rightMin = c; right = p.t;
      }
      else if(c < 0 && c > leftMax){
        leftMax = c;  left = p.t;
      }
    }

    if(left != -1){
      if(type[left] == 'B' || type[left] == 'Q'){
        System.out.println("YES");
        return;

      }
    }
    if(right != -1){
      if(type[right] == 'B' || type[right] == 'Q'){
        System.out.println("YES");
        return;
      }
    }

    tmp.clear();

    // right down
    for(int i = 0; i < n; i++){
      if(-(x[i] - kx) == y[i] - ky){
        tmp.add(new Pair(x[i] - kx, i));
      }
    }
    Pair[] rightDown = tmp.toArray(new Pair[tmp.size()]);

    leftMax = -INF; left = -1;
    right = -1; rightMin = INF;
    for(Pair p : rightDown){
      long c = p.s;
      if(c > 0 && c < rightMin){
       rightMin = c;  right = p.t;
      }
      else if(c < 0 && c > leftMax){
        leftMax = c;  left = p.t;
      }
    }

    if(left != -1){
      if(type[left] == 'B' || type[left] == 'Q'){
        System.out.println("YES");
        return;
      }
    }
    if(right != -1){
      if(type[right] == 'B' || type[right] == 'Q'){
        System.out.println("YES");
        return;
      }
    }

    System.out.println("NO");
  }

  static class Pair implements Comparable< Pair > {
    long s;
    int t;

    Pair(long s, int t){
      this.s = s; this.t = t;
    }

    @Override
      public int compareTo(Pair p){
        if(s == p.s){
          return t - p.t;
        }
        return Long.compare(s, p.s);
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
