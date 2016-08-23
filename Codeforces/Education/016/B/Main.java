import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  static Integer[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new Integer[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    Arrays.sort(a);

    if(n % 2 == 0){
      System.out.println(a[n / 2 - 1]);
    }
    else{
      System.out.println(a[n / 2]);
    }
  }
}
