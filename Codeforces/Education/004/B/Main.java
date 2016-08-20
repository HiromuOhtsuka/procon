import java.util.Scanner;

public class Main {
  static int n;
  static int[] f;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    f = new int[n];
    for(int i = 0; i < n; i++){
      f[i] = sc.nextInt() - 1;
    }

    int[] g = new int[n];
    for(int i = 0; i < n; i++){
      g[f[i]] = i;
    }

    long sum = 0;
    for(int i = 0; i < n - 1; i++){
      sum += Math.abs(g[i] - g[i + 1]);
    }

    System.out.println(sum);
  }
}
