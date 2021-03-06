import java.util.Scanner;

public class Main{
  static int n;
  static long[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextLong();
    }

    long k = 0;
    while(true){
      long sum = 0;
      for(int i = 0; i < n; i++){
        sum += a[i] / n;
      }
      for(int i = 0; i < n; i++){
        a[i] = a[i] - (a[i] / n) * n + (sum - a[i] / n);
      }
      boolean check = true;
      for(int i = 0; i < n; i++){
        if(a[i] >= n){
          check = false;
          break;
        }
      }
      k += sum;
      if(check){
        break;
      }
    }

    System.out.println(k);
  }
}
