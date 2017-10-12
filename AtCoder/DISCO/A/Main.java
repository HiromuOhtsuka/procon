import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    char[] str = sc.next().toCharArray();

    if(str[0] == str[1] && str[1] != str[2] && str[2] == str[3]){
      System.out.println("Yes");
    }
    else{
      System.out.println("No");
    }
  }
}
