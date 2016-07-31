import java.util.Scanner;

public class Main {
  static int n, l;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); l = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    for(int i = 0; i < n - 1; i++){
      long sum = (long)a[i] + a[i + 1];
      if(sum >= (long)l){
        System.out.println("Possible");
        for(int j = 0; j < i; j++){
          System.out.println(j + 1);
        }
        for(int j = n - 2; j >= i; j--){
          System.out.println(j + 1);
        }
        return;
      }
    }

    System.out.println("Impossible");
  }
}
