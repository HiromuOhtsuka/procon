import java.util.Scanner;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
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

    while(k > 0){
      long min = INF;
      int mini = -1;
      for(int i = 0; i < n; i++){
        if(min > (b[i] / a[i])){
          min = b[i] / a[i];
          mini = i;
        }
      }
      long d = a[mini] * (min + 1) - b[mini];
      if(k - d >= 0){
        b[mini] += d;
        k -= d;
      }
      else{
        break;
      }
    }

    long ans = INF;
    for(int i = 0; i < n; i++){
      ans = Math.min(ans, b[i] / a[i]);
    }

    System.out.println(ans);
  }
}
