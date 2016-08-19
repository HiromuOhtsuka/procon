import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n, k;
  static int[] c;
  static int[] id;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    c = new int[n];
    for(int i = 0; i < n; i++){
      c[i] = sc.nextInt();
    }
    id = new int[k];
    for(int i = 0; i < k; i++){
      id[i] = sc.nextInt() - 1;
    }

    long sum = 0;
    for(int i = 0; i < n; i++){
      sum += c[i] * c[(i + 1) % n];
    }

    long csum = 0;
    for(int i = 0; i < n; i++){
      csum += c[i];
    }

    long ksum = 0;
    for(int i = 0; i < k; i++){
      ksum += c[id[i]];
    }

    for(int i = 0; i < k; i++){
      sum += c[id[i]] * (csum - c[id[i]]);
    }
    for(int i = 0; i < k; i++){
      sum -= c[id[i]] * (c[(n + id[i] - 1) % n] + c[(id[i] + 1) % n]);
    }

    long tmp = 0;
    for(int i = 0; i < k; i++){
      long t = ksum - c[id[i]];
      int j = Arrays.binarySearch(id, (n + id[i] - 1) % n);
      if(0 <= j && j < k){
        t -= c[(n + id[i] - 1) % n];
      }
      j = Arrays.binarySearch(id, (id[i] + 1) % n);
      if(0 <= j && j < k){
        t -= c[(id[i] + 1) % n];
      }
      tmp += c[id[i]] * t;
    }

    sum -= tmp / 2;

    System.out.println(sum);
  }
}
