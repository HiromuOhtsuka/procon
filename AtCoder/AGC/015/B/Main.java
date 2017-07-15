import java.util.Scanner;

public class Main{
  static char[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next().toCharArray();
    long n = s.length;

    long sum = 0;
    for(long i = 0; i < n; i++){
      if(s[(int)i] == 'U'){
        sum += (n - i - 1) + 2 * i;
      }
      else{
        sum += i + 2 * (n - i - 1);
      }
    }

    System.out.println(sum);
  }
}
