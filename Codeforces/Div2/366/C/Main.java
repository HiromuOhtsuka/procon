import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int n, q;
  static int[] t, x;

  public static void main(String[] args){
    new Main();
  }

  public Main(){
    n = nextInt(); q = nextInt();
    t = new int[q]; x = new int[q];
    for(int i = 0; i < q; i++){
      t[i] = nextInt();  x[i] = nextInt() - 1;
    }

    int step = 0, read = 0;
    int size = 0;
    LinkedList< Pair > que = new LinkedList< Pair >();
    List< Queue< Pair > > list = new ArrayList< Queue< Pair > >();
    boolean[] used = new boolean[q];
    for(int i = 0; i < n; i++){
      list.add(new LinkedList< Pair >());
    }
    for(int i = 0; i < q; i++){
      if(t[i] == 1){
        Pair p = new Pair(step++, x[i]);
        que.offer(p);
        list.get(x[i]).add(p);
        ++size;
        System.out.println(size);
      }
      else if(t[i] == 2){
        Queue< Pair > tmp = list.get(x[i]);
        int count = 0;
        while(!tmp.isEmpty()){
          Pair p = tmp.poll();
          if(!used[p.s]){
            ++count;
          }
          used[p.s] = true;
        }
        size -= count;
        System.out.println(size);
      }
      else if(t[i] == 3){
        if(read <= x[i]){
          int count = 0;
          for(int j = read; j <= x[i]; j++){
            if(!used[j] && que.element().s <= j){
              que.remove();
              used[j] = true;
              ++count;
            }
            if(!used[j] && que.element().s > x[i]){
              break;
            }
          }
          size -= count;
          read = x[i];
        }
        System.out.println(size);
      }
    }
  }

  static class Pair {
    int s, t;

    Pair(int s, int t){
      this.s = s; this.t = t;
    }
  }


  /* Input */
  private static final InputStream in = System.in;
  private static final PrintWriter out = new PrintWriter(System.out);
  private final byte[] buffer = new byte[2048];
  private int p = 0;
  private int buflen = 0;

  private boolean hasNextByte() {
    if (p < buflen)
      return true;
    p = 0;
    try {
      buflen = in.read(buffer);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (buflen <= 0)
      return false;
    return true;
  }

  public boolean hasNext() {
    while (hasNextByte() && !isPrint(buffer[p])) {
      p++;
    }
    return hasNextByte();
  }

  private boolean isPrint(int ch) {
    if (ch >= '!' && ch <= '~')
      return true;
    return false;
  }

  private int nextByte() {
    if (!hasNextByte())
      return -1;
    return buffer[p++];
  }

  public String next() {
    if (!hasNext())
      throw new NoSuchElementException();
    StringBuilder sb = new StringBuilder();
    int b = -1;
    while (isPrint((b = nextByte()))) {
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
