import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, a, b;
  static char[] str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt();
    str = sc.next().toCharArray();
    if(str[a - 1] == str[b - 1]){
      System.out.println(0);
    }
    else{
      System.out.println(1);
    }
  }
}
