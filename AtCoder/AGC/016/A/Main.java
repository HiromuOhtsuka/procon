import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static char[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next().toCharArray();

    int min = s.length - 1;
    for(char ch = 'a'; ch <= 'z'; ch++){
      char[] t = Arrays.copyOf(s, s.length);
      int len = t.length;
      int count = 0;
      while(len > 1){
        boolean check = true;
        for(int i = 0; i + 1 < len; i++){
          if(t[i] != t[i + 1]){
            check = false;
            break;
          }
        }
        if(check){
          break;
        }
        for(int i = 0; i + 1 < len; i++){
          if(t[i + 1] == ch){
            t[i] = ch;
          }
        }
        --len;
        ++count;
      }
      min = Math.min(min, count);
    }

    System.out.println(min);
  }
}
