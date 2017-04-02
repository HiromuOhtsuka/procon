import java.util.Scanner;
import java.util.Arrays;

public class Sub{
  static int n, k;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int count = 0;
    for(int i = 0; i < n; i++){
      if(a[i] >= k){
        ++count;
      }
    }

    int[] b = new int[n - count];
    int m = 0;
    for(int i = 0; i < n; i++){
      if(a[i] < k){
        b[m++] = a[i];
      }
    }

    int ans = 0;
    for(int i = 0; i < m; i++){
      if(!check(i, b)){
        ++ans;
      }
    }

    System.out.println(ans);
  }

  private static boolean check(int index, int[] b){
    int[] c = new int[b.length - 1];
    int m = 0;
    for(int i = 0; i < b.length; i++){
      if(i != index){
        c[m++] = b[i];
      }
    }

    boolean[][] dp = new boolean[m + 1][k + 1];
    dp[0][0] = true;
    for(int i = 1; i <= m; i++){
      for(int j = 0; j < dp[i].length; j++){
        if(j - c[i - 1] >= 0){
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - c[i - 1]];
        }
        else{
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    for(int s = k - b[index]; s < k; s++){
      if(dp[m][s]){
        return true;
      }
    }

    return false;
  }
}
