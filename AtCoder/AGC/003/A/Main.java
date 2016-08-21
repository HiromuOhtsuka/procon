import java.util.Scanner;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();

    int n = s.length();
    int[] counts = new int[26];
    for(int i = 0; i < n; i++){
      ++counts[s.charAt(i) - 'A'];
    }

    boolean ok = true;
    if(counts['N' - 'A'] >= 1 && counts['S'- 'A'] < 1){
      ok = false;
    }
    if(counts['S'- 'A'] >= 1 && counts['N'- 'A'] < 1){
      ok = false;
    }
    if(counts['W'- 'A'] >= 1 && counts['E'- 'A'] < 1){
      ok = false;
    }
    if(counts['E'- 'A'] >= 1 && counts['W'- 'A'] < 1){
      ok = false;
    }

    if(ok){
      System.out.println("Yes");
    }
    else{
      System.out.println("No");
    }
  }
}
