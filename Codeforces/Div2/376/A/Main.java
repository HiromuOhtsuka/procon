import java.util.Scanner;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    char[] str = s.toCharArray();

    int sum = 0;
    char cur = 'a';
    for(int i = 0; i < str.length; i++){
      sum += Math.min(Math.abs(cur - str[i]), 26 - Math.abs(cur - str[i]));
      cur = str[i];
    }

    System.out.println(sum);
  }
}
