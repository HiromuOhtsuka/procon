import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static int n;
  static int[] s;
  static int q;
  static int[] t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = new int[n];
    for(int i = 0; i < n; i++){
      s[i] = sc.nextInt();
    }
    q = sc.nextInt();
    t = new int[q];
    for(int i = 0; i < q; i++){
      t[i] = sc.nextInt();
    }

    int count = 0;
    for(int i = 0; i < q; i++){
      if(Arrays.binarySearch(s, 0, n, t[i]) >= 0){
        ++count;
      }
    }

    System.out.println(count);
  }
}
