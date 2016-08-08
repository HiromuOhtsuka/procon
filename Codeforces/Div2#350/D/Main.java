import java.util.Scanner;

public class Main {
  static int n;
  static long k;
  static long[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    b = new long[n];
    for(int i = 0; i < n; i++){
      b[i] = sc.nextInt();
    }

    long cokie = 0;
    for(int i = 0; i < n; i++){
      cokie += a[i];
    }

    long low = -1, high = 2_000_000_001L;
    while(high - low > 1){
      long mid = (low + high) / 2;
      double need = 0;
      for(int i = 0; i < n; i++){
        if((b[i] / a[i]) < mid){
          need += (double)(a[i] * (double)mid - (double)b[i]);
        }
      }
      if(need <= k){
        low = mid;
      }
      else{
        high = mid;
      }
    }

    System.out.println(low);
  }
}
