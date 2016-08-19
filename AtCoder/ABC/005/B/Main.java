import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static int[] t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    t = new int[n];
    for(int i = 0; i < n; i++){
      t[i] = sc.nextInt();
    }

    int min = INF;
    for(int i = 0; i < n; i++){
      min = Math.min(min, t[i]);
    }

    System.out.println(min);
  }
}
