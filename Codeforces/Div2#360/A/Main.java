import java.util.Scanner;

public class Main {
  static int n, d;
  static String[] lines;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); d = sc.nextInt();
    lines = new String[d];
    for(int i = 0; i < d; i++){
      lines[i] = sc.next();
    }

    int max = 0;
    int conseq = 0;
    for(int i = 0; i < d; i++){
      boolean notwin = true;
      for(int j = 0; j < n; j++){
        if(lines[i].charAt(j) == '0'){
          notwin = false;
          break;
        }
      }
      if(!notwin){
        ++conseq;
        max = Math.max(max, conseq);
      }
      else{
        conseq = 0;
      }
    }

    System.out.println(max);
  }
}
