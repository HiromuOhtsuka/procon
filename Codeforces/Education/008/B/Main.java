import java.util.Scanner;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    char[] str = s.toCharArray();

    int n = s.length();
    long sum = 0;
    if((str[0] - '0') % 4 == 0){
      ++sum;
    }
    for(int i = 1; i < n; i++){
      long c = 0;
      if((str[i] - '0') % 4 == 0){
        ++c;
      }
      if((10 * (str[i - 1] - '0') + (str[i] - '0')) % 4 == 0){
        c += i;
      }
      sum += c;
    }

    System.out.println(sum);
  }
}
