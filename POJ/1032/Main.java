import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    int[] ans = new int[n];
    int sp = 0, m = n;
    if(n % 2 == 0){
      for(int d = 2; d <= n / 2; d++){
        if(m - d >= 0){
          ans[sp++] = d;
          m -= d;
        }
      }
    }
    else{
      for(int d = 2; d <= n / 2 + 1; d++){
        if(m - d >= 0){
          ans[sp++] = d;
          m -= d;
        }
      }
    }

    if(m > 0){
      while(m > 0){
        for(int i = sp - 1; m > 0 && i >= 0; i--){
          ++ans[i]; --m;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < sp; i++){
      sb.append(ans[i] + (((i == sp - 1) ? "\n" : " ")));
    }

    System.out.print(sb);
  }
}
