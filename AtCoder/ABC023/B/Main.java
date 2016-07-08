import java.util.Scanner;

public class Main {
  static int n;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.next();

    if(s.equals("b")){
      System.out.println(0);
      return;
    }

    StringBuilder sb = new StringBuilder("b");
    int step = 1;
    while(sb.length() <= n){
      if(step % 3 == 1){
        sb.insert(0, "a");
        sb.append("c");
      }
      else if(step % 3 == 2){
        sb.insert(0, "c");
        sb.append("a");
      }
      else{
        sb.insert(0, "b");
        sb.append("b");
      }
      if(sb.toString().equals(s)){
        System.out.println(step);
        return;
      }
      ++step;
    }

    System.out.println(-1);
  }
}
