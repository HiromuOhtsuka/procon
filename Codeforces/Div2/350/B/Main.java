import java.util.Scanner;

public class Main {
  static int n;
  static long k;
  static int[] id;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    id = new int[n];
    for(int i = 0; i < n; i++){
      id[i] = sc.nextInt();
    }

    long sum = 0;
    int i = 1;
    while(sum < k){
      sum += i;
      ++i;
    }
    --i;

    int j = (int)(i - (sum - k) - 1);
    int ans = id[j];

    System.out.println(ans);
  }
}
