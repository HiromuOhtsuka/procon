import java.util.Scanner;
import java.util.TreeMap;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt() - 1;
    }

    int[] ans = new int[n];
    for(int s = 0; s < n; s++){
      int[] counts = new int[n];
      int max = 1, maxi = a[s];
      for(int t = s; t < n; t++){
        ++counts[a[t]];
        int count = counts[a[t]];
        if(count >= max){
          if(count == max){
            if(maxi > a[t]){
              maxi = a[t];
            }
          }
          else{
            maxi = a[t];
            max = count;
          }
        }
        ++ans[maxi];
      }
    }

    for(int i = 0; i < n; i++){
      System.out.print(ans[i] + ((i == n -1) ? "\n" : " "));
    }
  }
}
