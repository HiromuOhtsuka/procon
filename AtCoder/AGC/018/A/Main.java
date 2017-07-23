import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main{
  static int n, k;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    Arrays.sort(a);

    if(a[n - 1] < k){
      System.out.println("IMPOSSIBLE");
      return;
    }

    if(n == 1){
      if(a[0] == k){
        System.out.println("POSSIBLE");
      }
      else{
        System.out.println("IMPOSSIBLE");
      }
      return;
    }

    for(int i = 0; i < n; i++){
      if(a[i] == k){
        System.out.println("POSSIBLE");
        return;
      }
    }

    for(int i = 0; i + 1 < n; i++){
      if(a[i + 1] - a[i] == 1){
        System.out.println("POSSIBLE");
        return;
      }
    }

    int diff = a[1] - a[0];
    boolean all = true;
    for(int i = 0; i + 1 < n; i++){
      if(a[i] == a[i + 1]){
        continue;
      }
      if(diff != a[i + 1] - a[i]){
        all = false;
        break;
      }
    }
    if(all){
      System.out.println("IMPOSSIBLE");
      return;
    }

    Set< Integer > diffs = new HashSet< >();
    for(int i = 0; i + 1 < n; i++){
      if(a[i + 1] == a[i]){
        continue;
      }
      diffs.add(a[i + 1] - a[i]);
    }

    for(Integer i : diffs){
      if(i != 0 && k % i == 0){
        System.out.println("POSSIBLE");
        return;
      }
    }

    System.out.println("IMPOSSIBLE");
  }
}
