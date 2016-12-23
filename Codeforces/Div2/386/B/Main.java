import java.util.Scanner;

public class Main {
  static int n;
  static String str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    str = sc.next();
    String ans = "";
    boolean flag = (n % 2 == 0);
    for(int i = 0; i < n; i++){
      if(flag){
        ans = str.substring(i, i + 1) + ans;
      }
      else{
        ans = ans + str.substring(i, i + 1);
      }
      flag = !flag;
    }

    System.out.println(ans);
  }
}
