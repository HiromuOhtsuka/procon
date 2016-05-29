import java.util.Scanner;

public class Main {
  static int[] l;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    l = new int[n];
    int len = 1;
    l[0] = a[0];
    for(int i = 1; i < n; i++){
      if(l[len - 1] < a[i]){
        l[len++] = a[i];
      }
      else{
        int j = lowerBound(a[i], -1, len);
        l[j] = a[i];
      }
    }

    System.out.println(len);
  }

  private static int lowerBound(int x, int low, int high){
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
