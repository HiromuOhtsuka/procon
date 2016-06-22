import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int d, e;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    for(;;){
      d = sc.nextInt(); e = sc.nextInt();

      if(d == 0 && e == 0){
        return;
      }

      double min = INF;
      for(int x = 0; x <= d; x++){
        int y = d - x;
        min = Math.min(min, Math.abs((double)e - Math.sqrt(x * x + y * y)));
      }

      System.out.println(min);
    }
  }
}
