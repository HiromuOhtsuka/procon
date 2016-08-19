import java.util.Scanner;

public class Main {
  static int n;
  static int[] t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    t = new int[n + 1];
    for(int i = 0; i < n; i++){
      t[i] = sc.nextInt();
    }
    t[n] = 90;
    n++;

    int ans = 90, time = 0;
    boolean flag = false;
    for(int i = 0; i < n; i++){
      if((t[i] - time) > 15){
        ans = time + 15;
        break;
      }
      time = t[i];
    }

    System.out.println(ans);
  }
}
