import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n, a;
  static Integer[] x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); a = sc.nextInt();
    x = new Integer[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt();
    }

    if(n == 1){
      System.out.println(0);
      return;
    }

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

    Arrays.sort(x);

    long ans = INF;
    int s = 0, t = 0, count = 0;
    for(;;){
      while(t < n && count < n - 1){
        count += counts.get(x[t]);
        t += counts.get(x[t]);
      }
      if(count >= n - 1){
        ans = Math.min(ans, 
          Math.min(Math.abs(a - x[s]), Math.abs(a - x[t - 1])) + x[t - 1] - x[s]);
      }
      else{
        break;
      }

      count -= counts.get(x[s]);
      ++s;

      if(s == n){
        break;
      }

    }

    System.out.println(ans);
  }
}
