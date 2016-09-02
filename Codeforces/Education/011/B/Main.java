import java.util.Scanner;

public class Main {
  static int n, m;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();

    int[] ans = new int[m];
    if(1 <= m && m <= 2 * n){
      for(int i = 0; i < m; i++){
        ans[i] = i + 1;
      }
    }
    else{
      int a = 2 * n + 1, b = 1;
      for(int i = 0; i < m; i++){
        if((i % 4 == 0 || i % 4 == 2) && a <= m){
          ans[i] = a++;
        }
        else{
          ans[i] = b++;
        }
      }
    }

    for(int i = 0; i < m; i++){
      System.out.print(ans[i] + ((i == m - 1) ? "\n" : " "));
    }
  }
}
