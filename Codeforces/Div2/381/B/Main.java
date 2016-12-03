import java.util.Scanner;

public class Main {
  static int n, m;
  static int[] a, l, r;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    l = new int[m]; r = new int[m];
    for(int i = 0; i < m; i++){
      l[i] = sc.nextInt() - 1;
      r[i] = sc.nextInt();
    }

    int[] s = new int[m];
    for(int i = 0; i < m; i++){
      for(int j = l[i]; j < r[i]; j++){
        s[i] += a[j];
      }
    }

    int ans = 0;
    for(int i = 0; i < m; i++){
      if(s[i] > 0){
        ans += s[i];
      }
    }

    System.out.println(ans);
  }
}
