import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    int k = 0;
    int[] a = new int[4];
    for(int i = 4; i >= 0; i--){
      if((n & (1 << i)) != 0){
        a[k++] = (1 << i);
      }
    }

    System.out.println(k);
    for(int i = 0; i < k; i++){
      System.out.println(a[k - i - 1]);
    }
  }
}
