import java.util.Scanner;

public class Main{
  static char[] s, t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next().toCharArray();
    t = sc.next().toCharArray();

    int last = -1;
    for(int i = 0; i + t.length - 1 < s.length; i++){
      boolean match = true;
      for(int j = 0; j < t.length; j++){
        if(s[i + j] == '?'){
          continue;
        }
        if(s[i + j] != t[j]){
          match = false;
          break;
        }
      }
      if(match){
        last = i;
      }
    }

    if(last == -1){
      System.out.println("UNRESTORABLE");
      return;
    }

    for(int i = 0; i < s.length; i++){
      if(s[i] == '?'){
        s[i] = 'a';
      }
    }
    for(int i = 0; i < t.length; i++){
      s[last + i] = t[i];
    }

    System.out.println(s);
  }
}
