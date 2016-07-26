import java.util.Scanner;

public class Main {
  static final int MAX = 1_000_000;
  static int n;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n]; b = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();  b[i] = sc.nextInt();
    }

    int[] c = new int[MAX + 1 + 1];
    for(int i = 0; i < n; i++){
      ++c[a[i]];
      --c[b[i] + 1];
    }

    int max = 0, count = 0;
    for(int i = 0; i < c.length; i++){
      count += c[i];
      max = Math.max(max, count);
    }

    System.out.println(max);
  }
}
