import java.util.Scanner;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    int n = s.length();
    int l = -1;
    for(int i = 0; i < n; i++){
      if(s.charAt(i) != 'a'){
        l = i - 1;  break;
      }
    }
    int r = l + 1;
    for(int i = l + 1; i < n; i++){
      if(s.charAt(i) == 'a'){
        break;
      }
      r = i + 1;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(s.substring(0, l + 1));
    for(int i = l + 1; i < r; i++){
      char tmp = (char)((26 + (s.charAt(i) - 'a') - 1) % 26 + 'a');
      sb.append(tmp);
    }
    if(r < n){
      sb.append(s.substring(r, n));
    }

    if(s.equals(sb.toString())){
      char[] tmp = new char[1];
      tmp[0] = (char)((26 + (sb.charAt(sb.length() - 1) - 'a') - 1) % 26 + 'a');
      sb = sb.replace(sb.length() - 1, sb.length(), new String(tmp));
    }

    System.out.println(sb.toString());
  }
}
