import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    String s = scan.nextLine();
    String t = scan.nextLine();

    int count = 0;
    for(int i = 0, sLen = s.length(); i < sLen; i++){
      if(i + t.length() >= sLen){
        break;
      }
      boolean same = true;
      for(int j = 0, tLen = t.length(); j < tLen; j++){
        if(s.charAt(i + j) != t.charAt(j)){
          same = false;
          break;
        }
      }
      if(same){
        ++count;
        i += t.length() - 1;
      }
    }

    System.out.println(count);
  }
}
