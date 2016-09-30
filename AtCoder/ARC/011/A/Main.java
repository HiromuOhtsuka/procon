import java.util.Scanner;

public class Main {
  static int m, n, N;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    m = sc.nextInt(); n = sc.nextInt(); N = sc.nextInt();
    int r = N, sum = N;
    while(r >= m){
      sum += (r / m) * n;
      int d = 0;
      if(r % m != 0){
        d = r % m;
      }
      r = (r / m) * n + d;
    }

    System.out.println(sum);
  }
}
