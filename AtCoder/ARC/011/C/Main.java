import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int n;
  static String first, last;
  static String[] s;

  static List< List< Integer > > G;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    first = sc.next();  last = sc.next();

    if(first.length() != last.length()){
      System.out.println(-1);
      return;
    }

    if(first.equals(last)){
      System.out.println(0);
      System.out.println(first);
      System.out.println(last);
      return;
    }

    n = sc.nextInt();
    s = new String[n + 2];
    s[0] = first;
    for(int i = 1; i <= n; i++){
      s[i] = sc.next();
      if(s[i].length() != first.length()){
        System.out.println(-1);
        return;
      }
    }
    s[n + 1] = last;

    G = new ArrayList< List< Integer > >(n + 2);
    for(int i = 0; i < n + 2; i++){
      G.add(new ArrayList< Integer >());
    }

    for(int i = 0; i <= n + 1; i++){
      for(int j = i + 1; j <= n + 1; j++){
        if(diff(s[i], s[j]) <= 1){
          G.get(i).add(j);  G.get(j).add(i);
        }
      }
    }

    Queue< E > que = new LinkedList< E >();
    que.offer(new E(0, 0, -1));
    int[] pre = new int[n + 2];
    boolean[] visited = new boolean[n + 2];
    boolean flag = false;
    while(!que.isEmpty()){
      E e = que.poll();
      if(visited[e.i]){
        continue;
      }
      visited[e.i] = true;
      pre[e.i] = e.p;
      if(e.i == n + 1){
        flag = true;  break;
      }
      for(int i = 0; i < G.get(e.i).size(); i++){
        int j = G.get(e.i).get(i);
        que.offer(new E(j, e.d + 1, e.i));
      }
    }

    if(flag){
      int[] path = new int[n + 2];
      int sp = 0;
      for(int i = pre[n + 1]; i != -1; i = pre[i]){
        //System.out.println(i);
        //System.out.println(s[i]);
        path[sp++] = i;
      }
      StringBuilder sb = new StringBuilder();
      sb.append(sp - 1);  sb.append(System.lineSeparator());
      for(int i = sp - 1; i >= 0; i--){
        sb.append(s[path[i]]); sb.append(System.lineSeparator());
      }
      sb.append(last);
      System.out.println(sb);
    }
    else{
      System.out.println(-1);
    }
  }

  static class E {
    int i, d, p;

    E(int i, int d, int p){
      this.i = i; this.d = d;
      this.p = p;
    }
  }

  private static int diff(String s1, String s2){
    int count = 0;
    for(int i = 0; i < s1.length(); i++){
      if(s1.charAt(i) != s2.charAt(i)){
        ++count;
      }
    }
    return count;
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
