import java.util.Scanner;

public class Main2 {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    int n = s.length();

    long ans = Long.parseLong(s);
    for(int d = 1; d <= n - 1; d++){
      for(int i = 0; i + d <= n; i++){
        long tmp = Long.parseLong(s.substring(i, i + d));
        if(i != 0 && i + d != n){
          ans += tmp * (1 << (n - d - 2));
        }
        else{
          ans += tmp * (1 << (n - d - 1));
        }
      }
    }

    System.out.println(ans);
  }
}
