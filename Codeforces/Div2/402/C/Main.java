import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static int n, k;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    a = new int[n];
    b = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    for(int i = 0; i < n; i++){
      b[i] = sc.nextInt();
    }

    int sum = 0;
    int count = 0;
    boolean[] choiseA = new boolean[n];
    for(int i = 0; i < n; i++){
      if(a[i] <= b[i]){
        sum += a[i];
        ++count;
        choiseA[i] = true;
      }
      else{
        sum += b[i];
      }
    }

    if(count >= k){
      System.out.println(sum);
      return;
    }

    Pair[] diff = new Pair[n];
    int sp = 0;
    for(int i = 0; i < n; i++){
      if(!choiseA[i]){
        diff[sp++] = new Pair(i, Math.abs(a[i] - b[i]));
      }
    }

    Arrays.sort(diff, 0, sp);

    for(int i = 0; i < k - count; i++){
      int j = diff[i].i;
      sum = sum - b[j] + a[j];
    }

    System.out.println(sum);
  }

  static class Pair implements Comparable< Pair >{
    int i;
    int val;

    Pair(int i, int val){
      this.i = i;
      this.val = val;
    }

    @Override
      public int compareTo(Pair p){
        if(val == p.val){
          return Integer.compare(i, p.i);
        }
        return Integer.compare(val, p.val);
      }
  }
}
