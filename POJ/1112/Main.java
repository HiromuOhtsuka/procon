import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.Arrays;

public class Main {
  static int n;
  static boolean[][] G, RG;
  static int[] cmp;
  static int count;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    G = new boolean[n][n];
    for(int i = 0; i < n; i++){
      int v = sc.nextInt();
      while(v != 0){
        G[i][v - 1] = true;
        v = sc.nextInt();
      }
    }

    RG = new boolean[n][n];
    for(int i = 0; i < n; i++){
      Arrays.fill(RG[i], true);
    }
    for(int v = 0; v < n; v++){
      for(int w = v + 1; w < n; w++){
        if(G[v][w] && G[w][v]){
          RG[v][w] = RG[w][v] = false;
        }
      }
    }

    int[] color = new int[n];
    cmp = new int[n];
    Arrays.fill(cmp, -1);
    for(int v = 0; v < n; v++){
      if(color[v] == 0){
        if(!coloring(v, 1, color)){
          //System.out.println("here1");
          System.out.println("No solution");
          //System.out.println("v:" + (v + 1));
          return;
        }
        ++count;
      }
    }

    int[][] pairs = new int[count][2];
    for(int i = 0; i < count; i++){
      for(int v = 0; v < n; v++){
        if(cmp[v] == i && color[v] == 1){
          ++pairs[i][0];
        }
        else if(cmp[v] == i && color[v] == 2){
          ++pairs[i][1];
        }
      }
    }

    boolean[][] dp = new boolean[count + 1][n + 1];
    dp[0][0] = true;
    for(int i = 1; i <= count; i++){
      for(int j = 0; j <= n; j++){
        boolean val = false;
        if(j - pairs[i - 1][0] >= 0){
          val = (val || dp[i - 1][j - pairs[i - 1][0]]);
        }
        if(j - pairs[i - 1][1] >= 0){
          val = (val || dp[i - 1][j - pairs[i - 1][1]]);
        }
        dp[i][j] = val;
      }
    }

    int half = n / 2, ans = -1;
    for(int d = 0; d <= n; d++){
      if(half + d <= n && dp[count][half + d]){
        ans = half + d;
        break;
      }
    }

    if(ans == -1){
      //System.out.println("here2");
      System.out.println("No solution");
      return;
    }

    int j = ans, sp1 = 0;
    int[] choices = new int[n];
    for(int i = count; i >= 1; i--){
      if(j - pairs[i - 1][0] >= 0 && dp[i - 1][j - pairs[i - 1][0]]){
        choices[sp1++] = 1;  j = j - pairs[i - 1][0];
      }
      else if(j - pairs[i - 1][1] >= 0 && dp[i - 1][j - pairs[i - 1][1]]){
        choices[sp1++] = 2;  j = j - pairs[i - 1][1];
      }
    }

    int[] a = new int[n], b = new int[n];
    int spa = 0, spb = 0;
    for(int i = 0; i < count; i++){
      if(choices[sp1 - i - 1] == 1){
        for(int v = 0; v < n; v++){
          if(color[v] == 1 && cmp[v] == i){
            a[spa++] = v;
          }
          else if(color[v] == 2 && cmp[v] == i){
            b[spb++] = v;
          }
        }
      }
      else{
        for(int v = 0; v < n; v++){
          if(color[v] == 2 && cmp[v] == i){
            a[spa++] = v;
          }
          else if(color[v] == 1 && cmp[v] == i){
            b[spb++] = v;
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(spa + " ");
    for(int i = 0; i < spa; i++){
      sb.append((a[i] + 1) + " ");
    }
    sb.append("\n");
    sb.append(spb + " ");
    for(int i = 0; i < spb; i++){
      sb.append((b[i] + 1) + " ");
    }

    System.out.println(sb);
  }

  private static boolean coloring(int v, int color, int[] c){
    cmp[v] = count;

    //System.out.println("v:" + (v + 1) + " c:" + color);
    for(int w = 0; w < n; w++){
      if(RG[v][w] && c[w] == 0 && cmp[w] == -1){
        if(!coloring(w, ((color == 1) ? 2 : 1), c)){
          return false;
        }
      }
    }
    for(int w = 0; w < n; w++){
      if(RG[v][w] && c[w] == color){
        return false;
      }
    }

    c[v] = color;
    return true;
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
