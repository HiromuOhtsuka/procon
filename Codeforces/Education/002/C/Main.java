import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    int n = s.length();
    char[] str = s.toCharArray();

    int[] counts = new int[26];
    for(int i = 0; i < n; i++){
      ++counts[str[i] - 'a'];
    }

    int odd = 0;
    for(int i = 0; i < 26; i++){
      if(counts[i] % 2 == 1){
        odd += counts[i];
      }
    }

    Arrays.sort(str);
    char[] s1 = new char[n], s2 = new char[n];
    int s = 0, t = n - 1, sp1 = 0, sp2 = 0;
    for(int i = 0; i < n; i++){
      if(counts[str[i] - 'a'] >= 2 && counts[str[i] - 'a'] % 2 == 0){
        s1[sp1++] = str[i];
        counts[str[i] - 'a'] -= 2;
      }
      else if(counts[str[i] - 'a'] % 2 == 1 && counts[str[i] - 'a'] >= 2){
        s1[sp1++] = str[i];
        counts[str[i] - 'a'] -= 2;
        odd -= 2;
      }
    }

    for(int i = 0; i < 26; i++){
      if(counts[i] == 1){
        s2[sp2++] = (char)(i + 'a');
      }
    }

    Arrays.sort(s2, 0, sp2);
    int sp = 0;
    char[] s3 = new char[sp1 + sp2];
    for(int i = 0; i < sp1; i++){
      s3[sp++] = s1[i];
    }
    for(int i = 0; i < sp2 / 2; i++){
      s3[sp++] = s2[i];
    }
    Arrays.sort(s3, 0, sp);
    if(n % 2 == 0){
      char[] ans = new char[sp * 2];
      for(int i = 0; i < ans.length / 2; i++){
        ans[i] = ans[ans.length - i - 1] = s3[i];
      }
      System.out.println(ans);
    }
    else{
      char[] ans = new char[sp * 2 + 1];
      for(int i = 0; i < ans.length / 2; i++){
        ans[i] = ans[ans.length - i - 1] = s3[i];
      }
      ans[ans.length / 2] = s2[sp2 / 2];
      System.out.println(ans);
    }
  }
}
