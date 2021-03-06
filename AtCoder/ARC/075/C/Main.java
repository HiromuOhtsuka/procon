import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static int n;
  static int[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = new int[n];
    for(int i = 0; i < n; i++){
      s[i] = sc.nextInt();
    }

    int sum = 0;
    for(int i = 0; i < n; i++){
      sum += s[i];
    }

    if(sum % 10 != 0){
      System.out.println(sum);
      return;
    }

    int max = 0;
    for(int i = 0; i < n; i++){
      if((sum - s[i]) % 10 != 0){
        max = Math.max(max, sum - s[i]);
      }
    }

    System.out.println(max);
  }
}
