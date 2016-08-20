import java.util.Scanner;

public class Main {
  static int n, m;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int[] counts = new int[m];
    for(int i = 0; i < n; i++){
      ++counts[a[i] - 1];
    }

    int ans = 0;
    for(int i = 0; i < m; i++){
      for(int j = i + 1; j < m; j++){
        ans += counts[i] * counts[j];
      }
    }

    System.out.println(ans);
  }
}
