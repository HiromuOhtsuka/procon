import java.util.Scanner;

public class Sub2 {
  static final int INF = Integer.MAX_VALUE / 2;
  static int r, g, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    r = sc.nextInt(); g = sc.nextInt(); b = sc.nextInt();

    if(r > 40 || g > 40 || b > 40){
      return;
    }

    int min = INF;
    for(int i = 0; i <= r - 1; i++){
      for(int j = 0; j <= g - 1; j++){
        for(int k = 0; k <= b - 1; k++){
          int l = r - i - 1, m = g - j - 1, n = b - k - 1;
          if(l < 0 || m < 0 || n < 0){
            continue;
          }
          int sum = i * (i + 1) / 2 + l * (l + 1) / 2 +
            j * (j + 1) / 2 + m * (m + 1) / 2 +
            k * (k + 1) / 2 + n * (n + 1) / 2;
          min = Math.min(min, sum);
        }
      }
    }

    System.out.println(min);
  }
}
