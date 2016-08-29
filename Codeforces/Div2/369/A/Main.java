import java.util.Scanner;

public class Main {
  static int n;
  static String[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = new String[n];
    for(int i = 0; i < n; i++){
      s[i] = sc.next();
    }

    char[][] strs = new char[n][];
    for(int i = 0; i < n; i++){
      strs[i] = s[i].toCharArray();
    }

    boolean ok = false;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < strs[i].length - 1; j++){
        if(strs[i][j] == 'O' && strs[i][j + 1] == 'O'){
          ok = true;
          strs[i][j] = '+'; strs[i][j + 1] = '+';
          break;
        }
      }
      if(ok){
        break;
      }
    }

    if(ok){
      System.out.println("YES");
      for(int i = 0; i < n; i++){
        System.out.println(strs[i]);
      }
    }
    else{
      System.out.println("NO");
    }
  }
}
