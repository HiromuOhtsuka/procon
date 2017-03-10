import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    int[] ans = new int[n];
    int k = 0;
    if(n % 2 == 0){
      k = n / 2;
      for(int i = 0; i < k; i++){
        ans[i] = 2;
      }
    }
    else{
      k = n / 2;
      for(int i = 0; i <= k - 2; i++){
        ans[i] = 2;
      }
      ans[k - 1] = 3;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(k + System.lineSeparator());
    for(int i = 0; i < k; i++){
      sb.append(ans[i] + " ");
    }

    System.out.println(sb);
  }
}
