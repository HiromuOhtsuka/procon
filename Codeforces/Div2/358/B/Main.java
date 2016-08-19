import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    Arrays.sort(a);
    int p = 1;
    for(int i = 0; i < n; i++){
      if(a[i] >= p){
        ++p;
      }
    }

    System.out.println(p);
  }
}
