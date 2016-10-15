import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      String ip = sc.next();
      for(int j = 0; j < 4; j++){
        int addr = Integer.parseInt(ip.substring(8 * j, 8 * (j + 1)), 2);
        sb.append(addr + ((j != 3 ? "." : "")));
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
