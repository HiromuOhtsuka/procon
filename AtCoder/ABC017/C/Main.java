import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, m;
  static int[] l, r, s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();

    int sum = 0;
    l = new int[n]; r = new int[n]; s = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt(); r[i] = sc.nextInt(); s[i] = sc.nextInt();
      sum += s[i];
    }

    int[] a = new int[m + 2];
    for(int i = 0; i < n; i++){
      a[l[i]] += s[i]; a[r[i] + 1] += -s[i];
    }

    for(int i = 1; i <= m + 1; i++){
      a[i] = a[i - 1] + a[i];
    }

    int min = INF;
    for(int i = 1; i <= m; i++){
      min = Math.min(min, a[i]);
    }

    int ans = sum - min;
    System.out.println(ans);
  }
}
