import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int c;
  static int[][] nml;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    c = sc.nextInt();
    nml = new int[c][3];
    for(int i = 0; i < c; i++){
      nml[i][0] = sc.nextInt();
      nml[i][1] = sc.nextInt();
      nml[i][2] = sc.nextInt();
    }

    for(int i = 0; i < c; i++){
      Arrays.sort(nml[i]);
    }

    int x = 0, y = 0, z = 0;
    for(int i = 0; i < c; i++){
      x = Math.max(x, nml[i][0]);
      y = Math.max(y, nml[i][1]);
      z = Math.max(z, nml[i][2]);
    }

    int v = x * y * z;

    System.out.println(v);
  }
}
