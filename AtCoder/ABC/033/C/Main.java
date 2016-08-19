import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    Stack< Integer > stack = new Stack< Integer >();

    String line = scan.nextLine();
    char[] str = line.toCharArray();
    for(int i = 0; i < str.length; i++){
      if('0' <= str[i] && str[i] <= '9'){
        stack.push(str[i] - '0');
      }
      else if(str[i] == '*'){
        int n = stack.pop();
        int tmp = n * (str[++i] - '0');
        if(tmp == 0){
          stack.push(0);
        }
        else{
          stack.push(1);
        }
      }
    }

    int count = 0;
    while(!stack.isEmpty()){
      if(stack.pop() != 0){
        ++count;
      }
    }

    System.out.println(count);
  }
}
