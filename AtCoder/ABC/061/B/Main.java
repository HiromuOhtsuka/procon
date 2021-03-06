import java.util.Scanner;

public class Main{
  static int n, m;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    a = new int[m];
    b = new int[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt() - 1;
      b[i] = sc.nextInt() - 1;
    }

    int[] d = new int[n];
    for(int i = 0; i < m; i++){
      d[a[i]]++;
      d[b[i]]++;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      sb.append(d[i] + System.lineSeparator());
    }

    System.out.print(sb);
  }
}
