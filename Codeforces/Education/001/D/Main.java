import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int n, m, k;
  static boolean[][] table;
  static int[] x, y;

  static int[][] counts;
  static boolean[][] visited1, visited2;
  static final int[] dx = new int[]{0, -1, 0, 1}, dy = new int[]{-1, 0, 1, 0};

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
    table = new boolean[n][m];
    for(int i = 0; i < n; i++){
      String line = sc.next();
      for(int j = 0; j < m; j++){
        if(line.charAt(j) == '*'){
          table[i][j] = true;
        }
      }
    }
    x = new int[k]; y = new int[k];
    for(int i = 0; i < k; i++){
      y[i] = sc.nextInt() - 1;  x[i] = sc.nextInt() - 1;
    }

    counts = new int[n][m];
    visited1 = new boolean[n][m];
    visited2 = new boolean[n][m];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        if(!table[i][j] && !visited1[i][j] && !visited2[i][j]){
          int c = dfs1(j, i);
          dfs2(j, i, c);
        }
      }
    }

    for(int i = 0; i < k; i++){
      int ans = counts[y[i]][x[i]];
      System.out.println(ans);
    }
  }

  private static int dfs1(int x, int y){
    if(table[y][x]){
      return 1;
    }
    if(visited1[y][x]){
      return 0;
    }
    visited1[y][x] = true;
    int sum = 0;
    for(int i = 0; i < 4; i++){
      int nx = x + dx[i], ny = y + dy[i];
      if(0 <= nx && nx < m && 0 <= ny && ny < n){
        sum += dfs1(nx, ny);
      }
    }
    return sum;
  }

  private static void dfs2(int x, int y, int v){
    if(visited2[y][x] || table[y][x]){
      return;
    }
    visited2[y][x] = true;
    counts[y][x] = v;
    for(int i = 0; i < 4; i++){
      int nx = x + dx[i], ny = y + dy[i];
      if(0 <= nx && nx < m && 0 <= ny && ny < n){
        dfs2(nx, ny, v);
      }
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
