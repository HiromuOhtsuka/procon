import java.util.Scanner;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    int x = s.charAt(0) - 'a', y = s.charAt(1) - '1';

    int[] dx = new int[]{0, -1, -1, -1, 0, 1, 1, 1},
      dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

    int count = 0;
    for(int i = 0; i < 8; i++){
      int nx = x + dx[i], ny = y + dy[i];
      if(0 <= nx && nx < 8 && 0 <= ny && ny < 8){
        ++count;
      }
    }

    System.out.println(count);
  }
}
