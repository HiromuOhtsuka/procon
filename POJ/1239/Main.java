import java.util.Scanner;

public class Main {
  static String[] dp1;
  static String[] dp2;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    while(!str.equals("0")){
      String ans = optimize(str);
      System.out.println(ans);
      str = sc.nextLine();
    }
  }

  private static String optimize(String str){
    int n = str.length();
    dp1 = new String[n + 1];

    dp1[n] = str;
    // minimize
    dp1[0] = "";
    for(int i = 1; i <= n; i++){
      for(int j = 0; j < i; j++){
        String value = str.substring(j, i);
        if(dp1[i] == null || 
            dp1[j] != null &&
            compare(dp1[j], value) < 0 && 
            compare(dp1[i], value) > 0){
          dp1[i] = value;
        }
      }
    }

    String min = dp1[n];

    dp2 = new String[n + 1];
    int idx = n - min.length();
    dp2[idx] = min;
    int d = 0;
    for(d = 0; d + 1< min.length() &&  min.charAt(d) == '0'; d++){
      idx = n - (min.length() - (d + 1));
      dp2[idx] = min.substring(d + 1, min.length());
    }
    for(int i = n - (min.length() - d) - 1; i >= 0; i--){
      for(int j = i + 1; j <= n - (min.length() - d) + 1; j++){
        String value = str.substring(i, j);
        if(dp2[i] == null || 
            dp2[j] != null && 
            compare(dp2[j], value) > 0 &&
            compare(dp2[i], value) < 0){
          dp2[i] = value;
        }
      }
    }

    String max = dp2[0];

    if(max == null || "".equals(max) || min.equals(max)){
      return str;
    }

    StringBuilder ans = new StringBuilder(max),
      sb = new StringBuilder(max);
    for(;;){
      ans.append("," + dp2[sb.length()]);
      sb.append(dp2[sb.length()]);
      if(sb.length() >= n){
        break;
      }
    }

    return ans.toString();
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

    if(s1.substring(d1, s1.length()).length() < s2.substring(d2, s2.length()).length()){
      return -1;
    }
    else if(s1.substring(d1, s1.length()).length() > s2.substring(d2, s2.length()).length()){
      return 1;
    }

    return s1.substring(d1, s1.length()).compareTo(s2.substring(d2, s2.length()));
  }
}
