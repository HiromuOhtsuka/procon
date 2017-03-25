import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static int n, m;
  static int[] l1, r1, l2, r2;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    l1 = new int[n];
    r1 = new int[n];
    for(int i = 0; i < n; i++){
      l1[i] = sc.nextInt();
      r1[i] = sc.nextInt();
    }
    m = sc.nextInt();
    l2 = new int[m];
    r2 = new int[m];
    for(int i = 0; i < m; i++){
      l2[i] = sc.nextInt();
      r2[i] = sc.nextInt();
    }

    Arrays.sort(l1);
    Arrays.sort(r1);
    Arrays.sort(l2);
    Arrays.sort(r2);

    int max = 0;
    if(r1[0] < l2[m - 1]){
      max = Math.max(max, l2[m - 1] - r1[0]);
    }
    if(r2[0] < l1[n - 1]){
      max = Math.max(max, l1[n - 1] - r2[0]);
    }

    System.out.println(max);
  }
}
