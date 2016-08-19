import java.util.Scanner;

public class Main {
  static int n, m, q;
  static int[] t, r, c, x;
  static int[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); q = sc.nextInt();
    t = new int[q]; r = new int[q]; c = new int[q];
    x = new int[q];
    for(int i = 0; i < q; i++){
      t[i] = sc.nextInt();
      if(t[i] == 1){
        r[i] = sc.nextInt() - 1;
      }
      else if(t[i] == 2){
        c[i] = sc.nextInt() - 1;
      }
      else{
        r[i] = sc.nextInt() - 1;  c[i] = sc.nextInt() - 1;
        x[i] = sc.nextInt();
      }
    }

    table = new int[n][m];
    int[][] mem = new int[n][m];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        mem[i][j] = m * i + j;
      }
    }

    for(int i = 0; i < q; i++){
      if(t[i] == 1){
        int first = mem[r[i]][0];
        for(int j = 0; j < m; j++){
          mem[r[i]][j] = mem[r[i]][(j + 1) % m];
        }
        mem[r[i]][m - 1] = first;
      }
      else if(t[i] == 2){
        int first = mem[0][c[i]];
        for(int j = 0; j < n; j++){
          mem[j][c[i]] = mem[(j + 1) % n][c[i]];
        }
        mem[n - 1][c[i]] = first;
      }
      else{
        table[mem[r[i]][c[i]] / m][mem[r[i]][c[i]] % m] = x[i];
      }
    }

    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        System.out.print(table[i][j] + ((j == m - 1) ? "\n" : " "));
      }
    }
  }
}
