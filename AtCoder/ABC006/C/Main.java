import java.util.Scanner;

public class Main {
  static int n, m;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();

    for(int i = 0; i <= 2 * n; i++){
      if((m - 2 * i) < 0 || (m - 2 * i) % 3 != 0){
        continue;
      }
      int b = (m - 2 * i) / 3;
      int a = 2 * n - 2 * b - i, c = i - n + b;
      if(a >= 0 && b >= 0 && c >= 0 && 
        a + b + c == n && 2 * a + 3 * b + 4 * c == m){
        System.out.println(a + " " + b + " " + c);
        return;
      }
    }

    System.out.println("-1 -1 -1");
  }
}
