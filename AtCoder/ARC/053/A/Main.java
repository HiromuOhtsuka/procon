import java.util.Scanner;

public class Main {
  static int H, W;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    H = sc.nextInt(); W = sc.nextInt();

    System.out.println(H * (W - 1) + W * (H - 1));
  }
}
