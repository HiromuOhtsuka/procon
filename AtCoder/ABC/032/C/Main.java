import java.util.Scanner;

public class Main {
  static int n;
  static long k;
  static long[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextLong();
    s = new long[n];
    for(int i = 0; i < n; i++){
      s[i] = sc.nextLong();
    }

    for(int i = 0; i < n; i++){
      if(s[i] == 0){
        System.out.println(n);
        return;
      }
    }

    int i = 0, j = 1, d = 0;
    long m = 1;
    while(i < j && j <= n){
      while(j <= n && m * s[j - 1] <= k){
        m *= s[j - 1];
        j++;
      }
      d = Math.max(d, j - i - 1);
      m /= s[i];
      ++i;
    }

    System.out.println(d);
  }
}
