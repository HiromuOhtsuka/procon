import java.util.Scanner;

public class Main {
  static int t, s, x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt(); s = sc.nextInt();
    x = sc.nextInt();

    if(x == t + 1){
      System.out.println("NO");
    }
    else if(x >= t && (x - t) % s == 0 || (x - t) % s == 1){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
