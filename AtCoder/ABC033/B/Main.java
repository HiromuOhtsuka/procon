import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    String[] s = new String[n]; int[] p = new int[n];
    int w = 0;
    for(int i = 0; i < n; i++){
      s[i] = scan.next();
      p[i] = scan.nextInt();
      w += p[i];
    }
    String name = "atcoder";
    for(int i = 0; i < n; i++){
      if(w < (p[i] * 2)){
        name = s[i];
      }
    }
    System.out.println(name);
  }
}
