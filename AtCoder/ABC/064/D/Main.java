import java.util.Scanner;

public class Main{
  static int n;
  static char[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.next().toCharArray();

    int right = 0;
    StringBuilder b = new StringBuilder();
    StringBuilder c = new StringBuilder();
    for(int i = 0; i < n; i++){
      if(s[i] == '('){
        ++right;
      }
      else{
        --right;
      }
      if(right < 0){
        b.append("(");
        ++right;
      }
    }
    for(int i = 0; i < right; i++){
      c.append(")");
    }

    System.out.print(b);
    System.out.print(s);
    System.out.println(c);
  }
}
