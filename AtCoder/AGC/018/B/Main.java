import java.util.Scanner;

public class Main{
  static int n, m;
  static int[][] a;

  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    a = new int[n][m];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        a[i][j] = sc.nextInt() - 1;
      }
    }

    int[] count = new int[m];
    for(int i = 0; i < n; i++){
      count[a[i][0]]++;
    }

    int min = 0;
    int maxi = -1;
    for(int i = 0; i < m; i++){
      if(min < count[i]){
        maxi = i;
        min = count[i];
      }
    }

    if(DEBUG){
      System.out.println("min = " + min);
    }

    boolean[][] check = new boolean[n][m];
    for(int i = 0; i < n; i++){
      check[i][0] = true;
    }

    boolean[] removed = new boolean[m];
    for(int i = 0; i < m - 1; i++){
      for(int j = 0; j < n; j++){
        for(int k = 0; k < m; k++){
          if(check[j][k] && a[j][k] == maxi){
            check[j][k] = false;
            boolean renew = false;
            for(int l = k - 1; l >= 0; l--){
              if(!removed[a[j][l]]){
                check[j][l] = true;
                renew = true;
                break;
              }
            }
            if(!renew){
              for(int l = k + 1; l < m; l++){
                if(!removed[a[j][l]]){
                  check[j][l] = true;
                  break;
                }
              }
            }
            break;
          }
        }
      }
      removed[maxi] = true;
      count = new int[m];
      for(int j = 0; j < n; j++){
        for(int k = 0; k < m; k++){
          if(check[j][k]){
            count[a[j][k]]++;
          }
        }
      }
      int lmin = 0;
      maxi = -1;
      for(int j = 0; j < m; j++){
        if(lmin < count[j]){
          maxi = j;
          lmin = count[j];
        }
      }
      if(DEBUG){
        System.out.println("lmin = " + lmin);
      }
      min = Math.min(min, lmin);
    }

    System.out.println(Math.max(1, min));
  }
}
