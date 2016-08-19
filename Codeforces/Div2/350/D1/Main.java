import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, k;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    b = new int[n];
    for(int i = 0; i < n; i++){
      b[i] = sc.nextInt();
    }

    while(k > 0){
      int min = INF, mini = -1;
      for(int i = 0; i < n; i++){
        if(min > (b[i] / a[i])){
          min = b[i] / a[i];
          mini = i;
        }
      }
      int d = a[mini] * (min + 1) - b[mini];
      if(k - d >= 0){
        b[mini] += d;
        k -= d;
      }
      else{
        break;
      }
    }

    int ans = INF;
    for(int i = 0; i < n; i++){
      ans = Math.min(ans, b[i] / a[i]);
    }

    System.out.println(ans);
  }
}
