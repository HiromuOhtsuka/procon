import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static char[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    //s = sc.next().toCharArray();
    String str = sc.next();
    s = new StringBuilder(str).reverse().toString().toCharArray();

    int sum = 0;
    for(int i = 0; i < s.length; i++){
      sum += (s[i] - '0') % 3;
    }

    if(sum % 3 == 0){
      System.out.println(str);
    }
    else if(sum % 3 == 1){
      boolean flag1 = false;
      boolean flag2 = false;

      char[] s1 = Arrays.copyOf(s, s.length);
      for(int i = 0; i < s1.length; i++){
        if(s1.length > 1 && (s1[i] - '0') % 3 == 1){
          s1[i] = 'x';
          flag1 = true;
          break;
        }
      }

      char[] s2 = Arrays.copyOf(s, s.length);
      int t1 = -1, t2 = -1;
      for(int i = 0; i < s.length; i++){
        if(s2.length > 2 && (s2[i] - '0') % 3 == 2){
          if(t1 == -1){
            t1 = i;
          }
          else if(t2 == -1){
            t2 = i;
            break;
          }
        }
      }
      if(t1 != -1 && t2 != -1){
        s2[t1] = s2[t2] = 'x';
        flag2 = true;
      }

      if(flag1 && !flag2){
        System.out.println(convert(s1));
      }
      else if(!flag1 && flag2){
        System.out.println(convert(s2));
      }
      else if(flag1 && flag2){
        String a1 = convert(s1);
        String a2 = convert(s2);
        if(a1.length() > a2.length()){
          System.out.println(a1);
        }
        else{
          System.out.println(a2);
        }
      }
      else{
        System.out.println(-1);
      }
    }
    else{
      boolean flag1 = false;
      boolean flag2 = false;

      char[] s1 = Arrays.copyOf(s, s.length);
      for(int i = 0; i < s1.length; i++){
        if(s1.length > 1 && (s1[i] - '0') % 3 == 2){
          s1[i] = 'x';
          flag1 = true;
          break;
        }
      }

      char[] s2 = Arrays.copyOf(s, s.length);
      int t1 = -1, t2 = -1;
      for(int i = 0; i < s.length; i++){
        if(s2.length > 2 && (s2[i] - '0') % 3 == 1){
          if(t1 == -1){
            t1 = i;
          }
          else if(t2 == -1){
            t2 = i;
            break;
          }
        }
      }
      if(t1 != -1 && t2 != -1){
        s2[t1] = s2[t2] = 'x';
        flag2 = true;
      }

      if(flag1 && !flag2){
        System.out.println(convert(s1));
      }
      else if(!flag1 && flag2){
        System.out.println(convert(s2));
      }
      else if(flag1 && flag2){
        String a1 = convert(s1);
        String a2 = convert(s2);
        if(a1.length() > a2.length()){
          System.out.println(a1);
        }
        else{
          System.out.println(a2);
        }
      }
      else{
        System.out.println(-1);
      }
    }
  }

  private static String convert(char[] s){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length; i++){
      if(s[i] != 'x'){
        sb.append(s[i]);
      }
    }
    int last = sb.length() - 1;
    while(last >= 0 && sb.charAt(last) == '0'){
      --last;
    }
    String result = new StringBuilder(sb.substring(0, last + 1)).reverse().toString();
    if(result.equals("")){
      return "0";
    }
    else{
      return result;
    }
  }
}
