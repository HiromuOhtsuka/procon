import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    int na = Math.max(1, n / 1234567), nb = Math.max(1, n / 123456), 
        nc = Math.max(1, n / 1234), sp = 0;
    long[] y = new long[(na + 1) * (nb + 1)];

    for(int b = 0; b <= nb; b++){
      for(int a = 0; a <= na; a++){
        long sum = a * 1234567 + b * 123456;
        if(sum <= n){
          y[sp++] = sum;
        }
      }
    }

    Arrays.sort(y, 0, sp);

    for(int c = 0; c <= nc; c++){
      long tar = n - c * 1234;
      int i = Arrays.binarySearch(y, 0, sp, tar);
      if(i >= 0){
        System.out.println("YES");
        return;
      }
    }

    System.out.println("NO");
  }
}
