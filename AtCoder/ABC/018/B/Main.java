import java.util.Scanner;

public class Main {
  static String s;
  static int n;
  static int[] l, r;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    n = sc.nextInt();
    l = new int[n]; r = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt() - 1;  r[i] = sc.nextInt();
    }

    StringBuilder ans = new StringBuilder(s);
    for(int i = 0; i < n; i++){
      StringBuilder tmp = new StringBuilder(ans.substring(l[i], r[i]));
      ans.replace(l[i], r[i], tmp.reverse().toString());
    }

    System.out.println(ans);
  }
}
