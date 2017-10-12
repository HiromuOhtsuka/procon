import java.util.Scanner;

public class Main{
  static int m, n;
  static int[] w;
  static final int INF = Integer.MAX_VALUE / 2;
  static final boolean DEBUG = true;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    while(true){
      m = sc.nextInt();
      n = sc.nextInt();
      if(m == 0 && n == 0){
        return;
      }
      w = new int[n];
      for(int i = 0; i < n; i++){
        w[i] = sc.nextInt();
      }

      int low = -1, high = INF;
      while(high - low > 1){
        int mid = (low + high) / 2;
        if(f(mid)){
          high = mid;
        }
        else{
          low = mid;
        }
      }

      System.out.println(high);
    }
  }

  static boolean f(int k){
    int sum = 0;
    int count = 1;
    for(int i = 0; i < n; i++){
      if(w[i] > k){
        return false;
      }
      if(sum + w[i] > k){
        ++count;
        sum = 0;
      }
      sum += w[i];
    }
    return count <= m;
  }
}
