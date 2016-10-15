import java.util.Scanner;

public class Main {
  static int n;
  static int[] p;
  static String[][] ss;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    p = new int[n];
    for(int i = 0; i < n; i++){
      p[i] = sc.nextInt();
    }

    sc.nextLine();

    ss = new String[n][];
    for(int i = 0; i < n; i++){
      ss[i] = sc.nextLine().split(" ");
    }

    for(int i = 0; i < n; i++){
      int sum = 0;
      for(int j = 0; j < ss[i].length; j++){
        sum += vowel(ss[i][j]);
      }
      if(sum != p[i]){
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");
  }

  private static int vowel(String s){
    int count = 0;
    for(int i = 0; i < s.length(); i++){
      char ch = s.charAt(i);
      if(ch == 'a' || ch == 'e' || ch == 'i' ||
        ch == 'o' || ch == 'u' || ch == 'y'){
        ++count;
      }
    }
    return count;
  }
}
