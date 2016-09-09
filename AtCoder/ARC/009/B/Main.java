import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

public class Main {
  static int n;
  static long[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    b = new long[10];
    for(int i = 0; i < 10; i++){
      int tmp = sc.nextInt();
      b[tmp] = i;
    }
    n = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextLong();
    }

    long[] c = new long[n];
    Map< Long, Long > map = new TreeMap< Long, Long >();
    for(int i = 0; i < n; i++){
      long src = a[i], dest = 0, base = 1;
      do{
        int r = (int)(src % 10);
        dest += base * b[r];
        base *= 10;
        src /= 10;
      }while(src != 0);
      c[i] = dest;
      map.put(c[i], a[i]);
    }

    Arrays.sort(c);

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      sb.append(map.get(c[i]));
      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }
}
