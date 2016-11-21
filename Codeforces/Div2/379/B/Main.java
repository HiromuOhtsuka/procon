import java.util.Scanner;

public class Main {
  static int k2, k3, k5, k6;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    k2 = sc.nextInt();  k3 = sc.nextInt();
    k5 = sc.nextInt();  k6 = sc.nextInt();

    int sum = 0, n256 = Math.min(k2, Math.min(k5, k6));
    sum += n256 * 256;
    sum += Math.max(0, Math.min(k3, k2 - n256)) * 32;

    System.out.println(sum);
  }
}
