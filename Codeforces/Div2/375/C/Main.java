import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n, m;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int[] b = new int[m];
    for(int i = 0; i < n; i++){
      if(a[i] <= m){
        ++b[a[i] - 1];
      }
    }

    int[] c = Arrays.copyOf(a, n);
    int tar = n / m;
    for(int i = 0; i < m; i++){
      if(b[i] < tar){
        int r = tar - b[i];
        for(int j = 0; r > 0 && j < n; j++){
          if(c[j] > m){
            c[j] = (i + 1); --r; ++b[i];
          }
        }
        for(int j = 0; r > 0 && j < n; j++){
          if(c[j] <= m && b[c[j] - 1] > tar){
            --b[c[j] - 1];
            c[j] = (i + 1); --r;  ++b[i];
          }
        }
      }
    }

    int count = 0;
    for(int i = 0; i < n; i++){
      if(a[i] != c[i]){
        ++count;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append((n / m) + " " + count + "\n");
    for(int i = 0; i < n; i++){
      sb.append(c[i] + ((i == n - 1) ? "\n" : " "));
    }

    System.out.print(sb);
  }
}
