import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n, m;
  static int[] l, r;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    l = new int[m]; r = new int[m];
    for(int i = 0; i < m; i++){
      l[i] = sc.nextInt() - 1;
      r[i] = sc.nextInt();
    }

    int min = n;
    for(int i = 0; i < m; i++){
      min = Math.min(min, r[i] - l[i]);
    }

    StringBuilder sb = new StringBuilder();
    sb.append(Math.max(min, 1) + System.lineSeparator());
    for(int i = 0; i < n; i++){
      sb.append((i + 1) % min + ((i == n - 1 ? System.lineSeparator() : " ")));
    }

    System.out.print(sb);
  }
}
