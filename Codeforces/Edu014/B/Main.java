import java.util.Scanner;

public class Main {
  static String str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    str = sc.next();

    char[] a = str.toCharArray();
    int n = str.length();
    if(n % 2 == 1){
      if(!mirror(a[n / 2], a[n / 2])){
        System.out.println("NIE");
        return;
      }
    }

    for(int i = 0; i < n / 2; i++){
      if(!mirror(a[i], a[n - i - 1])){
        System.out.println("NIE");
        return;
      }
    }

    System.out.println("TAK");
  }

  private static boolean mirror(char a, char b){
    return (a == 'b' && b == 'd') || (a == 'd' && b == 'b') ||
      (a == 'p' && b == 'q') || (a == 'q' && b == 'p') ||
      (a == 'o' && b == 'o') || (a == 'x' && b == 'x') ||
      (a == 'O' && b == 'O') || (a == 'X' && b == 'X') ||
      (a == 'w' && b == 'w') || (a == 'W' && b == 'W') ||
      (a == 'v' && b == 'v') || (a == 'V' && b == 'V') ||
      (a == 'Y' && b == 'Y') || (a == 'M' && b == 'M') ||
      (a == 'U' && b == 'U') || (a == 'T' && b == 'T') ||
      (a == 'A' && b == 'A') || (a == 'H' && b == 'H') ||
      (a == 'I' && b == 'I');
  }
}
