import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

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

    int[] ans = new int[n];
    int left = 0, rigth = n - 1;
    for(int i = 0; i < n; i++){
      if(i % 2 == 0){
        ans[i] = a[left++];
      }
      else{
        ans[i] = a[rigth--];
      }
    }

    for(int i = 0; i < n; i++){
      System.out.print(ans[i] + ((i == n - 1) ? "\n" : " "));
    }
  }
}
