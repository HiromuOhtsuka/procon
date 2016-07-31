import java.util.Scanner;

public class Main {
  static int n;
  static boolean[] check;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    check = new boolean[1000 + 1];
    for(int i = 0; i < n; i++){
      int a = sc.nextInt();
      check[a] = true;
    }

    int count = 0, ans = 0;
    for(int i = 1000; i >= 0; i--){
      if(check[i]){
        ++count;
      }
      if(count == 2){
        ans = i;
        break;
      }
    }

    System.out.println(ans);
  }
}
