import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n, a, b, k;
  static int[] p;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt();
    k = sc.nextInt();
    p = new int[k];
    for(int i = 0; i < k; i++){
      p[i] = sc.nextInt();
    }

    Arrays.sort(p);
    for(int i = 0; i < k; i++){
      if(p[i] == a || p[i] == b || (i + 1 < k && p[i] == p[i + 1])){
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");
  }
}
