import java.util.Scanner;

public class Main {
  static String w;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    w = sc.next();

    int n = w.length();
    char[] str = w.toCharArray();

    int[] counts = new int[26];
    for(int i = 0; i < n; i++){
      ++counts[str[i] - 'a'];
    }

    for(int i = 0; i < n; i++){
      if(counts[str[i] - 'a'] % 2 == 1){
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }
}
