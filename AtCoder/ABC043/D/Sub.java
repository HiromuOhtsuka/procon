import java.util.Scanner;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    int n = s.length();

    // sub
    for(int i = 0; i < n; i++){
      for(int j = i + 2; j <= n; j++){
        String sub = s.substring(i, j);
        int[] counts = new int[26];
        for(int k = 0; k < sub.length(); k++){
          ++counts[sub.charAt(k) - 'a'];
        }
        int sum = j - i;
        for(int k = 0; k < 26; k++){
          if(2 * counts[k] > sum){
            System.out.println((i + 1) + " " + j);
            return;
          }
        }
      }
    }

    System.out.println("-1 -1");
  }
}
