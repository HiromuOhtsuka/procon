import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n, k;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int[] b = Arrays.copyOf(a, n);
    int diff = 0;
    for(int i = 0; i < n - 1; i++){
      if(b[i] + b[i + 1] < k){
        b[i + 1] += k - (b[i] + b[i + 1]);
        diff += b[i + 1] - a[i + 1];
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(diff + System.lineSeparator());
    for(int i = 0; i < n; i++){
      sb.append(b[i] + ((i == n - 1) ? System.lineSeparator() : " "));
    }

    System.out.print(sb);
  }
}
