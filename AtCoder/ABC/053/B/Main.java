import java.util.Scanner;

public class Main{
  static char[] str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    str = sc.next().toCharArray();

    int s = -1;
    for(int i = 0; i < str.length; i++){
      if(str[i] == 'A'){
        s = i;
        break;
      }
    }

    int t = -1;
    for(int i = str.length - 1; i >= 0; i--){
      if(str[i] == 'Z'){
        t = i;
        break;
      }
    }

    System.out.println((t - s) + 1);
  }
}
