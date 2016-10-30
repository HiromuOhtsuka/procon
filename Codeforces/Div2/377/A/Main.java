import java.util.Scanner;

public class Main {
  static int k, r;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    k = sc.nextInt(); r = sc.nextInt();

    int n = 1;
    for(;;){
      int cost = k * n;
      int ten = cost - cost / 10 * 10;
      if(ten == 0 || ten == r){
        System.out.println(n);
        return;
      }
      ++n;
    }
  }
}
