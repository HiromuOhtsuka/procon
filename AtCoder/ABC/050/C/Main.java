import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  static final long MOD = 1_000_000_007L;
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    Map< Integer, Integer > count = new TreeMap< Integer, Integer >();
    count.put(0, 0);
    for(int i = 0; i < n; i++){
      if(count.containsKey(a[i])){
        count.put(a[i], count.get(a[i]) + 1);
      }
      else{
        count.put(a[i], 1);
      }
    }

    if((n % 2 == 1 && count.get(0) != 1)
      || (n % 2 == 0 && count.get(0) != 0)){
      System.out.println(0);
      return;
    }

    boolean check = true;
    for(int i = 0; i < n; i++){
      if(a[i] != 0 && count.get(a[i]) != 2){
        check = false;
        break;
      }
    }
    if(!check){
      System.out.println(0);
      return;
    }

    long ans = 1;
    for(int i = 0; i < n / 2; i++){
      ans = (ans * 2L) % MOD;
    }

    System.out.println(ans);
  }
}
