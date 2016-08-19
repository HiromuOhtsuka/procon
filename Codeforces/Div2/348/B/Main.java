import java.util.Scanner;

public class Main {
  static int n;
  static char[] s;
  static int[] d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    String line = sc.next();  s = line.toCharArray();
    d = new int[n];
    for(int i = 0; i < n; i++){
      d[i] = sc.nextInt();
    }

    int pos = 0;
    for(int i = 0; i < n; i++){
      if(s[pos] == '>'){
        pos += d[pos];
      }
      else{
        pos -= d[pos];
      }
      if(pos < 0 || pos >= n){
        System.out.println("FINITE");
        return;
      }
    }

    System.out.println("INFINITE");
  }
}
