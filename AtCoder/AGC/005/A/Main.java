import java.util.Scanner;

public class Main {
  static String x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x = sc.next();
    int n = x.length();

    char[] stack = new char[n];
    int sp = 0, count = 0;
    for(int i = 0; i < n; i++){
      if(x.charAt(i) == 'S'){
        stack[sp++] = 'S';
      }
      else{
        if(sp - 1 >= 0){
          sp--; ++count;
        }
      }
    }

    int ans = n - count * 2;

    System.out.println(ans);
  }
}
