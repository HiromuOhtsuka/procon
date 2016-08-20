import java.util.Scanner;
import java.util.Arrays;

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

    Arrays.sort(a);
    int sum = m, count = 0;
    for(int i = n - 1; i >= 0; i--){
      if(sum > 0){
        sum -= a[i];  ++count;
      }
      else{
        break;
      }
    }

    System.out.println(count);
  }
}
