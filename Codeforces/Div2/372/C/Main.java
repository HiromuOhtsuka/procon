import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    long[] p = new long[n + 1];
    p[1] = 2;
    for(long i = 2; i <= n; i++){
      // ((i * (i + 1)) * (i * (i + 1)) - i * (i - 1)) / i
      // = i * (i + 1) * (i + 1) - (i - 1)
      p[(int)i] = i * (i + 1) * (i + 1) - (i - 1);
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= n; i++){
      sb.append(p[i]);  sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }
}
