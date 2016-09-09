import java.util.Scanner;

public class Main {
  static int n;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n]; b = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();  b[i] = sc.nextInt();
    }

    int sum = 0;
    for(int i = 0; i < n; i++){
      sum += a[i] * b[i];
    }
    sum = (sum * 105 / 100);

    System.out.println(sum);
  }
}
