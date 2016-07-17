import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = new int[3];
    for(int i = 0; i < 3; i++){
      a[i] = sc.nextInt();
    }

    Arrays.sort(a);

    System.out.println(a[1]);
  }
}
