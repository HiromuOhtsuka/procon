import java.util.Scanner;

public class Main {
  static int n, a;
  static int[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); a = sc.nextInt() - 1;
    s = new int[n];
    for(int i = 0; i < n; i++){
      s[i] = sc.nextInt();
    }

    int count = (s[a] == 1) ? 1 : 0;
    for(int d = 1; d < n; d++){
      if(a - d >= 0 && a + d < n){
        if(s[a - d] + s[a + d] == 2){
          count += 2;
        }
      }
      else if(a + d < n){
        if(s[a + d] == 1){
          ++count;
        }
      }
      else if(a - d >= 0){
        if(s[a - d] == 1){
          ++count;
        }
      }
    }

    System.out.println(count);
  }
}
