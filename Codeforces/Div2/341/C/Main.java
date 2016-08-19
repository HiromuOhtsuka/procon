import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt(), p = scan.nextInt();
    int[] l = new int[n], r = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = scan.nextInt();
      r[i] = scan.nextInt();
    }

    double exp = 0.0;
    for(int i = 0; i < n; i++){
      double pos = (double)(((double)((r[i] / p - l[i] / p) + 1) / (r[i] - l[i] + 1)) + 
        (double)((double)((r[(i + 1) % n] / p - l[(i + 1) % n] / p + 1) / (r[(i + 1) % n] - l[(i + 1) % n] + 1)));
        exp += 1000.0 * pos;
    }

    System.out.printf("%.1f\n", exp);
  }
}
