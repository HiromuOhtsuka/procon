import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  static int[] m;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = new int[n];
    for(int i = 0; i < n; i++){
      m[i] = sc.nextInt();
    }

    int sum = 0;
    for(int i = 0; i < n; i++){
      sum += m[i];
    }

    Arrays.sort(m);
    int c = sum / n, r = sum % n, count = 0, diff = 0;
    for(int i = 0; i < n - r; i++){
      int tmp = diff;
      diff += m[i] - c;
      if(m[i] < c && diff < 0){
        count += Math.abs(diff - tmp);
      }
    }

    for(int i = n - r; i < n; i++){
      if(m[i] > c + 1){
        int tmp = diff;
        diff += m[i] - (c + 1);
        if(diff > 0){
          count += Math.abs(tmp - diff);
        }
      }
      else if(m[i] < c + 1){
        int tmp = diff;
        diff += m[i] - (c + 1);
        if(diff < 0){
          count += Math.abs(tmp - diff);
        }
      }
    }

    System.out.println(count);
  }
}
