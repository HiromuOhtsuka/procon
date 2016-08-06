import java.util.Scanner;

public class Main {
  static int n, q;
  static int[][] d;
  static int[] p;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    d = new int[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        d[i][j] = sc.nextInt();
      }
    }
    q = sc.nextInt();
    p = new int[q];
    for(int i = 0; i < q; i++){
      p[i] = sc.nextInt();
    }

    int[][] sum = new int[n][n];
    sum[0][0] = d[0][0];
    for(int i = 1; i < n; i++){
      sum[0][i] = sum[0][i - 1] + d[0][i];
      sum[i][0] = sum[i - 1][0] + d[i][0];
    }
    for(int i = 1; i < n; i++){
      for(int j = 1; j < n; j++){
        sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + d[i][j];
      }
    }

    int[] a = new int[n * n + 1];
    for(int i = 1; i <= n * n; i++){
      int max = 0;
      for(int j = 1; j <= i; j++){
        if(i % j != 0){
          continue;
        }
        int k = i / j;
        --j;  --k;
        if(i < 0 || k < 0){
          ++j;  ++k;
          continue;
        }
        for(int l = 0; l + k < n; l++){
          for(int o = 0; o + j < n; o++){
            int tmp = 0;
            if(o - 1 < 0 && l - 1 < 0){
             tmp = sum[l + k][o + j];
            }
            else if(o - 1 < 0){
             tmp = sum[l + k][o + j] - sum[l - 1][o + j];
            }
            else if(l - 1 < 0){
             tmp = sum[l + k][o + j] - sum[l + k][o - 1];
            }
            else{
             tmp = sum[l + k][o + j] - sum[l + k][o - 1] -
              sum[l - 1][o + j] + sum[l - 1][o - 1];
            }
            max = Math.max(max, tmp);
          }
        }
        ++j;  ++k;
      }
      a[i] = max;
    }

    for(int i = 0; i < q; i++){
      int max = 0;
      for(int j = 1; j <= p[i]; j++){
        max = Math.max(max, a[j]);
      }
      System.out.println(max);
    }
  }
}
