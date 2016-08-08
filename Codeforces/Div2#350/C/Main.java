import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
  static int n, m;
  static int[] a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    m = sc.nextInt();
    b = new int[m];
    for(int i = 0; i < m; i++){
      b[i] = sc.nextInt();
    }
    c = new int[m];
    for(int i = 0; i < m; i++){
      c[i] = sc.nextInt();
    }

    Map< Integer, Long > count = new HashMap< Integer, Long >();
    for(int i = 0; i < n; i++){
      if(count.containsKey(a[i])){
        long v = count.get(a[i]);
        count.put(a[i], v + 1L);
      }
      else{
        count.put(a[i], 1L);
      }
    }

    long max1 = -1, max2 = -1;
    int maxi = -1;
    for(int i = 0; i < m; i++){
      long tmp1 = 0;
      if(count.containsKey(b[i])){
        tmp1 += count.get(b[i]);
      }
      long tmp2 = 0;
      if(count.containsKey(c[i])){
        tmp2 += count.get(c[i]);
      }
      if(tmp1 == max1){
        if(tmp2 > max2){
          max2 = tmp2;
          maxi = i;
        }
      }
      else{
        if(tmp1 > max1){
          max1 = tmp1;
          max2 = tmp2;
          maxi = i;
        }
      }
    }

    System.out.println(maxi + 1);
  }
}
