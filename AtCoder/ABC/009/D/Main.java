import java.util.Scanner;

public class Main {
  static int k, m;
  static long[] a, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    k = sc.nextInt(); m = sc.nextInt();
    a = new long[k];  c = new long[k];
    for(int i = 0; i < k; i++){
      a[i] = sc.nextLong();
    }
    for(int i = 0; i < k; i++){
      c[i] = sc.nextLong();
    }

    long[][] mat = new long[k][k];
    for(int i = 1; i < k; i++){
      mat[i][i - 1] = -1;
    }
    for(int i = 0; i < k; i++){
      mat[0][i] = c[i];
    }

    long[][] mat2 = new long[k][k];
    for(int i = 0; i < k; i++){
      mat2[i][i] = -1;
    }

    long tmp = m - 1;
    do{
      if((tmp & 1L) != 0){
        mat2 = mul(mat2, mat, k);
      }
      tmp >>= 1L;
      mat = mul(mat, mat, k);
    } while(tmp != 0);

    long[] b = new long[k];
    for(int i = 0; i < k; i++){
      for(int j = 0; j < k; j++){
        b[i] ^= (mat2[i][j] & a[k - j - 1]);
      }
    }

    System.out.println(b[k - 1]);
  }

  private static long[][] mul(long[][] mat1, long[][] mat2, int n){
    long[][] ret = new long[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        for(int k = 0; k < n; k++){
          ret[i][j] ^= (mat1[i][k] & mat2[k][j]);
        }
      }
    }
    return ret;
  }
}
