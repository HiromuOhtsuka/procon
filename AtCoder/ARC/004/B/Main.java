import java.util.Scanner;

public class Main {
  static int n;
  static int[] d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    d = new int[n];
    for(int i = 0; i < n; i++){
      d[i] = sc.nextInt();
    }

    int sum = 0, max = 0;;
    for(int i = 0; i < n; i++){
      sum += d[i];
      max = Math.max(max, d[i]);
    }

    int min = 0;
    if(sum - max < max){
      min = max - (sum - max);
    }

    System.out.println(sum);  System.out.println(min);
  }
}
