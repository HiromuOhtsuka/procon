import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  static int[] m;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = new int[n];
    for(int i = 0; i < n; i++){
      m[i] = sc.nextInt();
    }

    int sum = 0;
    for(int i = 0; i < n; i++){
      sum += m[i];
    }

    int c = sum / n, r = sum % n;
    int[] a = new int[n];
    for(int i = 0; i < n - r; i++){
      a[i] = c;
    }
    for(int i = n - r; i < n; i++){
      a[i] = c + 1;
    }

    Arrays.sort(m);
    int diff = 0;
    for(int i = 0; i < n; i++){
      diff += Math.abs(m[i] - a[i]);
    }

    int ans = diff / 2;
    System.out.println(ans);

  }
}
