import java.util.Scanner;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, m, k;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int min = INF;
    int count = 1;
    for(int i = (m - 1) + 1; i < n; i++){
      if(a[i] != 0 && a[i] <= k){
        min = Math.min(min, 10 * count);
        break;
      }
      ++count;
    }
    count = 1;
    for(int i = (m - 1) - 1; i >= 0; i--){
      if(a[i] != 0 && a[i] <= k){
        min = Math.min(min, 10 * count);
        break;
      }
      ++count;
    }

    System.out.println(min);
  }
}
