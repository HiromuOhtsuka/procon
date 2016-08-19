import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  static int[] l;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    l = new int[2 * n];
    for(int i = 0; i < 2 * n; i++){
      l[i] = sc.nextInt();
    }

    Arrays.sort(l);

    int sum = 0;
    for(int i = 0; i < 2 * n; i += 2){
      sum += l[i];
    }

    System.out.println(sum);
  }
}

