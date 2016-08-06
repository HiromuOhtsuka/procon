import java.util.Scanner;

public class Sub1 {
  static final int INF = Integer.MAX_VALUE / 2;
  static int r, g, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    r = sc.nextInt(); g = sc.nextInt(); b = sc.nextInt();

    if(r > 5 || g > 5 || b > 5){
      return;
    }

    int min = INF;
    for(int s1 = 0; s1 < (1 << r); s1++){
      for(int s2 = 0; s2 < (1 << g); s2++){
        for(int s3 = 0; s3 < (1 << b); s3++){
          int sum = 0, c = 0;
          for(int i = 0; i < r - 1; i++){
            if((s1 & (1 << i)) != 0){
              ++c;
            }
          }
          sum += c * (c + 1) / 2 + (r - c - 1) * (r - c + 1 - 1) / 2;
          c = 0;
          for(int i = 0; i < g - 1; i++){
            if((s2 & (1 << i)) != 0){
              ++c;
            }
          }
          sum += c * (c + 1) / 2 + (g - c - 1) * (g - c + 1 - 1) / 2;
          c = 0;
          for(int i = 0; i < b - 1; i++){
            if((s3 & (1 << i)) != 0){
              ++c;
            }
          }
          sum += c * (c + 1) / 2 + (b - c - 1) * (b - c + 1 - 1) / 2;
          min = Math.min(min, sum);
        }
      }
    }

    System.out.println(min);
  }
}
