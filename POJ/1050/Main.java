import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static int[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    table = new int[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        table[i][j] = sc.nextInt();
      }
    }

    int[][] sum = new int[n][n];
    sum[0][0] = table[0][0];
    for(int i = 1; i < n; i++){
      sum[0][i] = sum[0][i - 1] + table[0][i];
      sum[i][0] = sum[i - 1][0] + table[i][0];
    }

    for(int i = 1; i < n; i++){
      for(int j = 1; j < n; j++){
        sum[i][j] = table[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
      }
    }

    int max = -INF;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        for(int k = i; k < n; k++){
          for(int l = j; l < n; l++){
            int tmp;
            if(i - 1 >= 0 && j - 1 >= 0){
              tmp = sum[k][l] - sum[k][j - 1] - sum[i - 1][l] + sum[i - 1][j - 1];
            }
            else if(i - 1 >= 0){
              tmp = sum[k][l] - sum[i - 1][l];
            }
            else if(j - 1 >= 0){
              tmp = sum[k][l] - sum[k][j - 1];
            }
            else{
              tmp = sum[k][l];
            }
            max = Math.max(max, tmp);
          }
        }
      }
    }

    System.out.println(max);
  }
}
