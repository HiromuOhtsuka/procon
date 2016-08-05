import java.util.Scanner;

public class Sub2 {
  static int n, m;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();

    if(n > 1500){
      return;
    }

    for(int i = 0; i <= n; i++){
      for(int j = 0; j <= n; j++){
        int k = n - (i + j);
        if(k < 0){
          continue;
        }
        if(2 * i + 3 * j + 4 * k == m){
          System.out.println(i + " " + j + " " + k);
          return;
        }
      }
    }

    System.out.println("-1 -1 -1");
  }
}
