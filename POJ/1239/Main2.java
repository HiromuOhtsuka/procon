import java.util.Scanner;

public class Main2 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    while(!"0".equals(str)){
      String ans = search(str);
      System.out.println(ans);
      str = sc.nextLine();
    }
  }

  private static String search(String str){
    int n = str.length();
    for(int right = n; right >= 0; right--){
      for(int left = right; left >= 1; left--){
        String ls = str.substring(0, left);
        String rs = str.substring(right, n);
        // skip 0
        while(left <= (right - 1) && right - 1 >= 0 && str.charAt(right - 1) == '0'){
          --right;
        }
        String mid = search(str.substring(left, right), ls, rs);
        if(mid != null && compare(ls, rs) < 0){
          if(compare(rs, str) == 0){
            return str;
          }
          if("".equals(mid)){
            return ls + "," + rs;
          }
          return ls + "," + mid + "," + rs;
        }
      }
    }
    return str;
  }

  private static String search(String str, String min, String max){
    int n = str.length();
    int count = 0;
    String ret = str;

    if(str.length() == 0){
      return str;
    }

    if(compare(min, str) < 0 && compare(str, max) < 0){
      ++count;
    }
    for(int left = 0; left <= n; left++){
      for(int right = left; right < n; right++){
        String ls = str.substring(0, left);
        String rs = str.substring(right, n);
        if(compare(ls, rs) < 0 && compare(min, ls) < 0 && compare(rs, max) < 0){
          String mid = search(str.substring(left, right), ls, rs);
          if(mid != null){
            if("".equals(mid)){
              ret = ls + "," + rs;
            }
            else{
              ret = ls + "," + mid + "," + rs;
            }
            ++count;
            if(count >= 2){
              return null;
            }
          }
        }
      }
    }
    if(count == 1){
      return ret;
    }
    return null;
  }

  private static int compare(String s1, String s2){
    int d1 = 0;
    while(d1 < s1.length() && s1.length() >= 1 && s1.charAt(d1) == '0'){
      d1++;
    }
    int d2 = 0;
    while(d2 < s2.length() && s2.length() >= 1 && s2.charAt(d2) == '0'){
      d2++;
    }

    String ss1 = s1.substring(d1, s1.length()), ss2 = s2.substring(d2, s2.length());
    if(ss1.length() < ss2.length()){
      return -1;
    }
    else if(ss1.length() > ss2.length()){
      return 1;
    }

    return ss1.compareTo(ss2);
  }

}
