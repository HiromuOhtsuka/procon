import java.util.Scanner;

public class Main {
  static int n;
  static int[] c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    c = new int[n];
    String line = sc.next();
    for(int i = 0; i < n; i++){
      c[i] = line.charAt(i) - '0' - 1;
    }

    int max = 0, min = n;
    for(int i = 0; i < 4; i++){
      int count = 0;
      for(int j = 0; j < n; j++){
        if(c[j] == i){
          ++count;
        }
      }
      min = Math.min(min, count);
      max = Math.max(max, count);
    }

    System.out.println(max + " " + min);
  }
}
