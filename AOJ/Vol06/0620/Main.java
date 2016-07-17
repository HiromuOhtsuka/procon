import java.util.Scanner;

public class Main {
  static int n, m;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    for(int k = 0; k < m; k++){
      for(int i = 0; i < n - 1; i++){
        if(a[i] % (k + 1) > a[i + 1] % (k + 1)){
          int tmp = a[i];
          a[i] = a[i + 1];
          a[i + 1] = tmp;
        }
      }
    }

    for(int i = 0; i < n; i++){
      System.out.println(a[i]);
    }
  }
}
