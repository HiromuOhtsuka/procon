import java.util.Scanner;

public class Main {
  static int n;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.next();

    char[] str = s.toCharArray();
    int out = 0, countIn = 0;
    boolean inPar = false;
    int i = 0;
    while(i < n){
      while(i < n && str[i] == '_'){
        ++i;
      }

      if(i == n){
        break;
      }

      if(str[i] == '('){
        inPar = true; ++i;
        continue;
      }
      else if(str[i] == ')'){
        inPar = false; ++i;
        continue;
      }

      int st = i;
      while(i < n && 
        (str[i] != '_' && str[i] != '(' && str[i] != ')')){
          ++i;
      }

      if(inPar){
        ++countIn;
      }
      else{
        out = Math.max(out, i - st);
      }
    }

    System.out.println(out + " " + countIn);
  }
}
