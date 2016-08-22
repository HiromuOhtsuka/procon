import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    Arrays.sort(a);

    int left = a[0], right = a[n - 1];
    for(int i = 0; i < 100; i++){
      if(f((left * 2 + right) / 3) <= f((left + right * 2) / 3)){
        right = (left + right * 2) / 3;
      }
      else{
        left = (left * 2 + right) / 3;
      }
    }

    int ans = (left + right) / 2;

    System.out.println(ans);
  }

  private static long f(int x){
    long sum = 0;
    for(int i = 0; i < n; i++){
      sum += Math.abs(a[i] - x);
    }
    return sum;
  }
}
