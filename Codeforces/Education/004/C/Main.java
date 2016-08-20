import java.util.Scanner;

public class Main {
  static int n;
  static String s;
  static char[] str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    n = s.length();
    str = s.toCharArray();

    char[] stack = new char[n];
    int sp = 0;
    int count = 0;
    for(int i = 0; i < n; i++){
      if(str[i] == '(' || str[i] == '<' || 
        str[i] == '{' || str[i] == '['){
        if(sp + 1 >= n){
          System.out.println("Impossible");
          return;
        }
        stack[sp++] = str[i];
      }
      else{
        if(sp - 1 < 0){
          System.out.println("Impossible");
          return;
        }
        char ch = stack[--sp];
        if(ch == '(' && str[i] != ')'){
          ++count;
        }
        else if(ch == '<' && str[i] != '>'){
          ++count;
        }
        else if(ch == '{' && str[i] != '}'){
          ++count;
        }
        else if(ch == '[' && str[i] != ']'){
          ++count;
        }
      }
    }

    if(sp != 0){
      System.out.println("Impossible");
    }
    else{
      System.out.println(count);
    }
  }
}
