import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, a;
  static Integer[] x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); a = sc.nextInt();
    x = new Integer[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt();
    }

    Arrays.sort(x);

    Map< Integer, Integer > counts = new TreeMap< Integer, Integer >();
    for(int i = 0; i < n; i++){
      if(counts.containsKey(x[i])){
        int v = counts.get(x[i]);
        counts.put(x[i], v + 1);
      }
      else{
        counts.put(x[i], 1);
      }
    }

    int min1 = INF, mini1 = -1, min2 = INF, mini2 = -1;
    for(int i = 0; i < n; i++){
      if(min1 >= Math.abs(x[i] - a)){
        min2 = min1;
        min1 = Math.abs(x[i] - a);
        mini2 = mini1;
        mini1 = i;
      }
      else if(min2 > Math.abs(x[i] - 1)){
        min2 = Math.abs(x[i] - 1);
        mini2 = i;
      }
    }

    if(n == 1){
      System.out.println(0);
      return;
    }

    int s = mini1;
    long sum1 = min1;
    for(int i = counts.get(x[mini1]); i < n - 1; i += counts.get(x[s])){
      sum1 += Math.abs(x[(s + 1) % n] - x[s]);
      s = (s + 1) % n;
    }
    s = mini1;
    long sum2 = min1;
    for(int i = counts.get(x[mini2]); i < n - 1; i += counts.get(x[s])){
      sum2 += Math.abs(x[(n + s - 1) % n] - x[s]);
      s = (n + s - 1) % n;
    }
    s = mini2;
    long sum3 = min2;
    for(int i = counts.get(x[mini2]); i < n - 1; i += counts.get(x[s])){
      sum3 += Math.abs(x[(s + 1) % n] - x[s]);
      s = (s + 1) % n;
    }
    s = mini2;
    long sum4 = min2;
    for(int i = counts.get(x[mini2]); i < n - 1; i += counts.get(x[s])){
      sum4 += Math.abs(x[(n + s - 1) % n] - x[s]);
      s = (n + s - 1) % n;
    }

    long ans = Math.min(Math.min(sum1, sum2), Math.min(sum3, sum4));

    System.out.println(ans);
  }
}
