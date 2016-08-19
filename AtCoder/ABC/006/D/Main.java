import java.util.Scanner;

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

    LIS lis = new LIS(n, a);
    lis.optimize();
    int ans = n - lis.getBestValue();

    System.out.println(ans);
  }
}

class LIS {
  int n;
  int[] a;

  int[] l;
  int length;
  int bestValue;

  LIS(int n, int[] a){
    this.n = n;
    this.a = new int[n];
    for(int i = 0; i < this.a.length; i++){
      this.a[i] = a[i];
    }
    this.l = new int[n];
  }

  void optimize(){
    length = 1;
    l[0] = a[0];
    for(int i = 1; i < n; i++){
      if(l[length - 1] < a[i]){
        l[length++] = a[i];
      }
      else{
        int j = lowerBound(a[i], -1, length);
        l[j] = a[i];
      }
    }
    bestValue = length;
  }

  int getBestValue(){
    return bestValue;
  }

  private int lowerBound(int x, int low, int high){
    while(high - low > 1){
      int mid = (high + low) / 2;
      if(l[mid] >= x){
        high = mid;
      }
      else{
        low = mid;
      }
    }
    return high;
  }
}
