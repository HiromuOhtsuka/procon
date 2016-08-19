import java.util.Scanner;

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

    int d = 0, s = 0, t = 0;
    while(s < n){
      while(t + 1 < n && a[t] < a[t + 1]){
        t++;
      }
      d = Math.max(d, t - s + 1);
      s = t + 1;
      t = s;
    }

    System.out.println(d);
  }
}
