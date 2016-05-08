import java.util.Scanner;

public class Main {

  static String str;
  static int pos = 0;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCase = in.nextInt();

    for(int i=0;i<testCase;i++){
      str = in.next();
      pos = 0;

      int answer = expression();

      System.out.println(answer);
    }

  }

  public static int expression(){
    int tmp1 = term();
    if(pos < str.length() && (str.charAt(pos) == '+' || str.charAt(pos) == '-')){
      char c = str.charAt(pos);
      pos++;
      int tmp2 = expression();
      if(c == '+'){
        return tmp1 + tmp2;
      }
      else{
        return tmp1 - tmp2;
      }
    }
    return tmp1;
  }

  public static int term(){
    int tmp1 = factor();
    if(pos < str.length() && (str.charAt(pos) == '*' || str.charAt(pos) == '/')){
      char c = str.charAt(pos);
      pos++;
      int tmp2 = term();
      if(c == '*'){
        return tmp1 * tmp2;
      }
      else{
        return tmp1 / tmp2;
      }
    }
    return tmp1;
  }

  public static int factor(){
    if(str.charAt(pos) == '('){
      pos++;
      int tmp = expression();
      pos++;
      return tmp;
    }
    return scanInt();
  }

  public static int scanInt(){
    int sum = 0;
    while(pos < str.length() && ('0' <= str.charAt(pos) && str.charAt(pos) <= '9')){
      sum = sum*10 + (str.charAt(pos) - '0');
      pos++;
    }
    return sum;
  }

  // <???> ::= <term> | <term> +- <expression>
  // <term> ::= <factor> | <factor> */ <term>
  // <factor> ::= ??°??? | (???)
  //

}
