import java.util.Scanner;

public class Main {
  static int n;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.next();

    char[] str = s.toCharArray();
    int a = 0, d = 0;
    for(int i = 0; i < n; i++){
      if(str[i] == 'A'){
        ++a;
      }
      else{
        ++d;
      }
    }

    if(a > d){
      System.out.println("Anton");
    }
    else if(a < d){
      System.out.println("Danik");
    }
    else{
      System.out.println("Friendship");
    }
  }
}
