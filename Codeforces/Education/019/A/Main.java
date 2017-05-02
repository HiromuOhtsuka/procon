import java.util.Scanner;

public class Main{
  static int n, k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();

    if(k == 1){
      System.out.println(n);
      return;
    }

    int[] a = new int[k];
    int count = 0;
    int i = 2;
    while(i < n && count < k - 1){
      if(n % i == 0){
        a[count++] = i;
        n /= i;
      }
      else{
        ++i;
      }
    }
    a[count++] = n;

    if(count != k){
      System.out.println(-1);
    }
    else{
      StringBuilder sb = new StringBuilder();
      for(int j = 0; j < k; j++){
        sb.append(a[j] + " ");
      }
      System.out.println(sb);
    }
  }
}
