import java.util.Scanner;

public class Main {
  static int n, k;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    s = sc.next();
    char[] str = s.toCharArray();

    int m = k;
    char[] ans = new char[n];
    for(int i = 0; i < n; i++){
      if(m == 0){
        ans[i] = str[i];
        continue;
      }
      if(m >= 26){
        if(str[i] <= 'm'){
          m -= 'z' - str[i];
          ans[i] = 'z';
        }
        else{
          m -= str[i] - 'a';
          ans[i] = 'a';
        }
      }
      else{
        if(str[i] <= 'm'){
          if('z' - str[i] <= m){
            m -= 'z' - str[i];
            ans[i] = 'z';
          }
          else{
            ans[i] = (char)(str[i] + m);
            m = 0;
          }
        }
        else{
          if(str[i] - 'a' <= m){
            m -= str[i] - 'a';
            ans[i] = 'a';
          }
          else{
            ans[i] = (char)(str[i] - m);
            m = 0;
          }
        }
      }
    }

    if(diff(str, ans) == k){
      System.out.println(ans);
    }
    else{
      System.out.println(-1);
    }
  }

  private static int diff(char[] str1, char[] str2){
    int sum = 0;
    for(int i = 0; i < str1.length; i++){
      sum += Math.abs(str1[i] - str2[i]);
    }
    return sum;
  }
}
