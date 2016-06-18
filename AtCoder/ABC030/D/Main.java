import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n, a;
  static long k;
  static int[] b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); a = sc.nextInt() - 1;
    String kline = sc.next();
    b = new int[n];
    for(int i = 0; i < n; i++){
      b[i] = sc.nextInt() - 1;
    }

    int step = 0, at = b[a];
    List< Integer > visited = new ArrayList< Integer >();
    while(!visited.contains(at)){
      visited.add(at);
      at = b[at];
      ++step;
    }

    long loop = visited.size() - visited.indexOf(at);

    if(kline.length() <= 6){
      int tmp = Integer.parseInt(kline);
      if(tmp <= n){
        int pos = b[a];
        --tmp;
        while(tmp > 0){
          pos = b[pos];
          --tmp;
        }
        System.out.println(pos + 1);
        return;
      }
    }

    k = 0;
    for(int i = 0; i < kline.length(); i++){
      k = (k * 10 + (kline.charAt(i) - '0')) % loop;
    }
    while(k < (step - loop)){
      k += loop;
    }

    int pos = a;
    while(k > 0){
      pos = b[(int)k];
      --k;
    }

    System.out.println(pos + 1);
  }
}
