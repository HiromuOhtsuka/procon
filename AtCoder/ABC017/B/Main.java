import java.util.Scanner;

public class Main {
  static int n;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    n = s.length();
    char[] str = s.toCharArray();

    boolean flag = true;
    for(int i = n - 1; i >= 0; i--){
      if(str[i] == 'h'){
        if(!(i - 1 >= 0 && str[i - 1] == 'c')){
          flag = false;
          break;
        }
        else{
          --i;
        }
      }
      else if(!(str[i] == 'o' || str[i] == 'k' || str[i] == 'u')){
        flag = false;
        break;
      }
    }

    if(flag){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
