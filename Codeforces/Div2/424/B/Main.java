import java.util.Scanner;

public class Main{
  static char[] s1, s2;
  static char[] t;
  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s1 = sc.next().toCharArray();
    s2 = sc.next().toCharArray();
    t = sc.next().toCharArray();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < t.length; i++){
      if(!(Character.toLowerCase(t[i]) >= 'a' &&
        Character.toLowerCase(t[i]) <= 'z')){
        sb.append(t[i]);
        continue;
      }
      int p = -1;
      for(int j = 0; j < s1.length; j++){
        if(Character.toLowerCase(t[i]) == s1[j]){
          p = j;
          break;
        }
      }
      if(DEBUG){
        System.out.println("p = " + p);
      }
      if(Character.isUpperCase(t[i])){
        sb.append(Character.toUpperCase(s2[p]));
      }
      else{
        sb.append(s2[p]);
      }
    }

    System.out.println(sb);
  }
}
