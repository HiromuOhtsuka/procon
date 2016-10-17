import java.util.Scanner;

public class Main {
  static int a, b, c;
  static boolean[] check;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();

    check = new boolean[101];
    check[a] = check[b] = check[c] = true;

    int count = 0;
    for(int i = 1; i <= 100; i++){
      if(check[i]){
        ++count;
      }
    }


    System.out.println(count);
  }
}
