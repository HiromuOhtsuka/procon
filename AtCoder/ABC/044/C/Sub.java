import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n, a;
  static int[] x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); a = sc.nextInt();
    x = new int[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt();
    }

    // sub
    if(n > 16){
      return;
    }

    Pair[] sums = new Pair[1 << n];
    int sp = 0;
    for(int s = 0; s < (1 << n); s++){
      int sum = 0, c = 0;
      for(int i = 0; i < n; i++){
        if((s & (1 << i)) != 0){
          sum += x[i];
          ++c;
        }
      }
      sums[sp++] = new Pair(sum, c);
    }

    int count = 0;
    for(int i = 1; i <= n; i++){
      int tar = i * a;
      for(int j = 0; j < sp; j++){
        if(tar == sums[j].s && i == sums[j].t){
          ++count;
        }
      }
    }

    System.out.println(count);
  }

  static class Pair {
    int s, t;

    Pair(int s, int t){
      this.s = s; this.t = t;
    }
  }

}
