import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

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

    Arrays.sort(s, new Comparator< String >(){
        @Override
        public int compare(String s1, String s2){
          return (s1 + s2).compareTo(s2 + s1);
        }
    });

    for(int i = 0; i < n; i++){
      System.out.print(s[i]);
    }
    System.out.println();
  }
}


