import java.util.Scanner;
import java.util.Stack;

public class Main{
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();

    int[] counts = new int[26];
    for(int i = 0; i < s.length(); i++){
      ++counts[s.charAt(i) - 'a'];
    }

    char min = 'z';
    for(int i = 0; i < 26; i++){
      if(counts[i] >= 1){
        min = (char)(i + 'a');
        break;
      }
    }

    StringBuilder u = new StringBuilder();
    Stack< Character > stack = new Stack< >();
    int i = 0;
    while(i < s.length()){
      stack.push(s.charAt(i));
      --counts[s.charAt(i) - 'a'];
      ++i;
      for(int j = 0; j < 26; j++){
        if(counts[j] >= 1){
          min = (char)(j + 'a');
          break;
        }
      }
      while(!stack.isEmpty() && stack.peek() <= min){
        u.append(stack.pop());
      }
    }

    while(!stack.isEmpty()){
      u.append(stack.pop());
    }

    System.out.println(u);
  }
}
