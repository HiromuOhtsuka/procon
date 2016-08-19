import java.util.Scanner;

public class Main {
  static int n, x;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); x = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int sum = 0;
    for(int i = 0; i < n; i++){
      if((x & (1 << i)) != 0){
        sum += a[i];
      }
    }

    System.out.println(sum);
  }
}
