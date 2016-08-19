import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static String s;
  static final int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();

    int n = s.length();
    int[] m = new int[n];
    int count = 0, c = 0;
    for(int i = n - 1; i >= 0; i--){
      if(s.charAt(i) == '+'){
        ++count;
        m[i] = INF;
      }
      else if(s.charAt(i) == '-'){
        --count;
        m[i] = INF;
      }
      else{
        m[i] = count;
        ++c;
      }
    }

    Arrays.sort(m);

    long sum = 0;
    for(int i = 0; i < (c / 2); i++){
      sum -= m[i];
    }
    for(int i = (c / 2); i < c; i++){
      sum += m[i];
    }

    System.out.println(sum);
  }
}
