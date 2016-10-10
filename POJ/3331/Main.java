import java.util.Scanner;
import java.math.BigInteger;

public class Main {
  static int t;
  static int[] day, digit;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt();
    day = new int[t]; digit = new int[t];
    for(int i = 0; i < t; i++){
      day[i] = sc.nextInt();  digit[i] = sc.nextInt();
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < t; i++){
      // the number of days is at most 365
      BigInteger fact = new BigInteger("1");
      for(int j = 2; j <= day[i]; j++){
        fact = fact.multiply(new BigInteger(Integer.toString(j)));
      }
      int count = 0;
      String s = fact.toString();
      for(int j = 0; j < s.length(); j++){
        if(s.charAt(j) - '0' == digit[i]){
          ++count;
        }
      }
      sb.append(count + "\n");
    }

    System.out.print(sb);
  }
}
