import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int n;
  static int[] a, ans;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    a = new int[n]; ans = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt() - 1;
      ans[i] = a[i];
    }

    int[] ind = new int[n];
    for(int v = 0; v < n; v++){
      ++ind[a[v]];
    }

    boolean[] flag = new boolean[n];
    Queue< Integer > que = new LinkedList< Integer >();
    for(int v = 0; v < n; v++){
      if(!flag[v] && ind[v] == 0){
        que.offer(v);
      }
    }
    while(!que.isEmpty()){
      int v = que.poll();
      --ind[a[v]];  flag[v] = true;
      if(!flag[a[v]] && ind[a[v]] == 0){
        que.offer(a[v]);
      }
    }

    int root = -1;
    for(int v = 0; v < n; v++){
      if(!flag[v] && ind[v] >= 1){
        if(root == -1 || a[v] == v){
          root = v;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    if(root == -1){
      sb.append(0); sb.append(System.lineSeparator());
      for(int i = 0; i < n; i++){
        sb.append(a[i] + 1 + ((i == n - 1 ? System.lineSeparator() : " ")));
      }
    }
    else{
      for(int v = 0; v < n; v++){
        if(!flag[v] && ind[v] >= 1){
          ans[v] = root;
          int w = a[v];
          while(w != v){
            flag[w] = true;
            w = a[w];
          }
        }
      }

      int count = 0;
      for(int i = 0; i < n; i++){
        if(ans[i] != a[i]){
          ++count;
        }
      }

      sb.append(count); sb.append(System.lineSeparator());
      for(int i = 0; i < n; i++){
        sb.append(ans[i] + 1 + ((i == n - 1 ? System.lineSeparator() : " ")));
      }
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
