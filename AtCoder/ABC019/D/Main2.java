import java.util.Scanner;

public class Main2 {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    int max = 0, maxi = 0;
    for(int i = 2; i <= n; i++){
      System.out.println("? " + 1 + " " + i);
      int d = sc.nextInt();
      if(max < d){
        max = d;
        maxi = i;
      }
    }

    max = 0;
    for(int i = 1; i <= n; i++){
      if(i != maxi){
        System.out.println("? " + maxi + " " + i);
        int d = sc.nextInt();
        max = Math.max(max, d);
      }
    }

    System.out.println("! " + max);
  }
}
