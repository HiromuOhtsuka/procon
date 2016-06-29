import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int[] rika, syakai;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    rika = new int[4];
    for(int i = 0; i < 4; i++){
      rika[i] = sc.nextInt();
    }
    syakai = new int[2];
    for(int i = 0; i < 2; i++){
      syakai[i] = sc.nextInt();
    }

    Arrays.sort(rika);
    Arrays.sort(syakai);

    int sum = rika[3] + rika[2] + rika[1] + syakai[1];

    System.out.println(sum);
  }
}
