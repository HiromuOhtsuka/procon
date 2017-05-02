import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static int[] a;

  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    Arrays.sort(a);

    int sum = 0;
    int i = n - 1;
    while(i >= 0 && a[i] >= 0){
      sum += a[i--];
    }

    if(sum % 2 == 1){
      System.out.println(sum);
      return;
    }

    if(DEBUG){
      System.out.println("i = " + i);
    }

    int min = INF;
    for(int j = n - 1; j > i; j--){
      if(a[j] % 2 == 1){
        min = Math.min(min, a[j]);
      }
    }

    int s1 = -INF, s2 = -INF;
    if(min != INF){
      s1 = sum - min;
    }

    int max = -INF;
    for(int j = i; j >= 0; j--){
      if(-a[j] % 2 == 1){
        max = Math.max(max, a[j]);
      }
    }
    s2 = sum + max;

    sum = Math.max(s1, s2);

    System.out.println(sum);
  }
}
