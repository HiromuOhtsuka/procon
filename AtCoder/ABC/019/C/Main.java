import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static final long INF = Integer.MAX_VALUE;
  static int n;
  static long[] a;
  static Set< Long > set;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextLong();
    }

    set = new TreeSet< Long >();
    for(int i = 0; i < n; i++){
      set.add(a[i]);
    }

    for(int i = 0; i < n; i++){
      long b = a[i] << 1;
      while(b < INF){
        if(set.contains(b)){
          set.remove(b);
        }
        b <<= 1;
      }
    }

    System.out.println(set.size());
  }
}
