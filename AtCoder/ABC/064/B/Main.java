import java.util.Scanner;

public class Main{
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int max = a[0], min = a[0];
    for(int i = 1; i < n; i++){
      max = Math.max(max, a[i]);
      min = Math.min(min, a[i]);
    }

    System.out.println(max - min);
  }
}
