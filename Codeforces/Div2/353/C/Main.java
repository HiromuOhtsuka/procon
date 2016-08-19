import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long sum = 0;
    Map< Long, Integer > count = 
      new TreeMap< Long, Integer >();
    for(int i = 0; i < n; i++){
      sum += a[i];
      if(count.containsKey(sum)){
        int val = count.get(sum);
        count.remove(sum);
        count.put(sum, val + 1);
      }
      else{
        count.put(sum, 1);
      }
    }

    int max = 0;
    for(Integer i : count.values()){
      max = Math.max(max, i);
    }

    int ans = n - max;

    System.out.println(ans);
  }
}
