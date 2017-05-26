import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
  static int n, f;
  static int[] k, l;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    f = sc.nextInt();
    k = new int[n];
    l = new int[n];
    for(int i = 0; i < n; i++){
      k[i] = sc.nextInt();
      l[i] = sc.nextInt();
    }

    int[] two = new int[n];
    for(int i = 0; i < n; i++){
      two[i] = Math.min(2 * k[i], l[i]) - Math.min(k[i], l[i]);
    }

    Integer[] idx = new Integer[n];
    for(int i = 0; i < n; i++){
      idx[i] = i;
    }

    Arrays.sort(idx, new Comparator< Integer >(){
      @Override
        public int compare(Integer i1, Integer i2){
          return -Integer.compare(two[i1], two[i2]);
        }
    });

    long sum = 0;
    for(int i = 0; i < f; i++){
      int j = idx[i];
      sum += Math.min(2 * k[j], l[j]);
    }

    for(int i = f; i < n; i++){
      int j = idx[i];
      sum += Math.min(k[j], l[j]);
    }

    System.out.println(sum);
  }
}
