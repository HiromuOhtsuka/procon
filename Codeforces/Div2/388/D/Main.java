import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
  static int n;
  static int[] max;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();

    List< List< Integer > > bids = new ArrayList< >();
    for(int i = 0; i < n; i++){
      bids.add(new ArrayList< >());
    }

    max = new int[n];
    for(int i = 0; i < n; i++){
      int a = sc.nextInt() - 1, b = sc.nextInt();
      max[a] = Math.max(max[a], b);
      bids.get(a).add(b);
    }

    for(int i = 0; i < n; i++){
      Collections.sort(bids.get(i));
    }

    TreeSet< Pair > set = new TreeSet< >();
    for(int i = 0; i < n; i++){
      if(max[i] != 0){
        set.add(new Pair(i, max[i]));
      }
    }

    StringBuilder sb = new StringBuilder();
    int q = sc.nextInt();
    for(int i = 0; i < q; i++){
      int k = sc.nextInt();
      int[] l = new int[k];
      for(int j = 0; j < k; j++){
        l[j] = sc.nextInt() - 1;
        if(max[l[j]] != 0){
          set.remove(new Pair(l[j], max[l[j]]));
        }
      }
      if(!set.isEmpty()){
        Pair win = set.last();
        Pair sec = set.lower(win);
        if(sec == null){
          if(Collections.binarySearch(bids.get(win.i), win.bid) >= 0){
            sb.append((win.i + 1) + " " + bids.get(win.i).get(0));
          }
          else{
            sb.append((win.i + 1) + " " + win.bid);
          }
        }
        else{
          int j = Collections.binarySearch(bids.get(win.i), sec.bid);
          j = -j - 1;
          sb.append((win.i + 1) + " " + bids.get(win.i).get(j));
        }
        sb.append(System.lineSeparator());
      }
      else{
        sb.append("0 0" + System.lineSeparator());
      }
      for(int j = 0; j < k; j++){
        if(max[l[j]] != 0){
          set.add(new Pair(l[j], max[l[j]]));
        }
      }
    }

    System.out.println(sb);
  }

  static class Pair implements Comparable< Pair >{
    int i;
    int bid;

    Pair(int i, int bid){
      this.i = i;
      this.bid = bid;
    }

    @Override
      public int compareTo(Pair p){
        if(bid == p.bid){
          return Integer.compare(i, p.i);
        }
        return Integer.compare(bid, p.bid);
      }

    @Override
      public boolean equals(Object obj){
        if(!(obj instanceof Pair)){
          return false;
        }
        Pair p = (Pair)obj;
        return bid == p.bid && i == p.i;
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
