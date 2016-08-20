import java.util.Scanner;

public class Main {
  static int n, p, q;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); p = sc.nextInt(); q = sc.nextInt();
    s = sc.next();

    String[] ans = null;
    for(int i = 0; i <= n / p; i++){
      for(int j = 0; j <= n / q; j++){
        if(p * i + q * j != n){
          continue;
        }
        ans = new String[i + j];
        int sp = 0, st = 0;
        for(int k = 0; k < i; k++){
          ans[sp++] = s.substring(st, st + p);
          st += p;
        }
        for(int k = 0; k < j; k++){
          ans[sp++] = s.substring(st, st + q);
          st += q;
        }
        break;
      }
    }

    if(ans == null){
      System.out.println(-1);
    }
    else{
      System.out.println(ans.length);
      for(int i = 0; i < ans.length; i++){
        System.out.println(ans[i]);
      }
    }
  }
}
