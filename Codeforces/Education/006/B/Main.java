import java.util.Scanner;

public class Main {
  static int a, b;
  static final int[] c = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt();

    long count = 0;
    for(int i = a; i <= b; i++){
      int tmp = i;
      while(tmp != 0){
        count += c[tmp % 10];
        tmp /= 10;
      }
    }

    System.out.println(count);
  }
}
