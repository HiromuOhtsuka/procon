import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x = sc.nextInt(); y = sc.nextInt();

    int sec = 0;
    int[] tri = new int[]{y, y, y};
    while(tri[0] != x || tri[1] != x || tri[2] != x){
      Arrays.sort(tri);
      tri[0] = Math.min(x, tri[1] + tri[2] - 1);
      ++sec;
    }

    System.out.println(sec);
  }
}
