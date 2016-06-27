import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, m;
  static int[][] p;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    p = new int[m][2];
    for(int i = 0; i < m; i++){
      int v = sc.nextInt() - 1, w = sc.nextInt() - 1;
      p[i][0] = v;  p[i][1] = w;
    }

    int[] a = new int[n];
    int min1 = n, max2 = -1;
    for(int i = 0; i < m; i++){
      int max = Math.max(p[i][0], p[i][1]);
      int min = Math.min(p[i][0], p[i][1]);
      if(a[max] == 0){
        a[max] = 1;
        min1 = Math.min(min1, max);
      }
      else if(a[max] != 1){
        System.out.println(0);
        return;
      }
      if(a[min] == 0){
        a[min] = 2;
        max2 = Math.max(max2, min);
      }
      else if(a[min] != 2){
        System.out.println(0);
        return;
      }
    }

    for(int i = 0; i < n; i++){
      if(a[i] == 0){
        if(i < max2){
          a[i] = 2;
        }
        else if(i > min1){
          a[i] = 1;
        }
      }
    }

    if(!(max2 < min1)){
      System.out.println(0);
      return;
    }

    if(max2 != -1 && min1 != n){
      if(min1 - max2 - 1 >= 1){
        int tmp = min1 - max2 - 1;
        System.out.println(tmp + 1);
      }
      else {
        System.out.println(1);
      }
    }
    else{
      System.out.println(n - 1);
    }
  }
}
