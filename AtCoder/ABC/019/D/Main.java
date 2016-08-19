import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    int max = 0;
    for(int i = 0; i < n; i++){
      for(int j = i + 1; j < n; j++){
        System.out.println("? " + (i + 1) + " " + (j + 1));
        int d = sc.nextInt();
        max = Math.max(max, d);
      }
    }

    System.out.println("! " + max);
  }
}
