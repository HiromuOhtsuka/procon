import java.util.Scanner;

public class Main {
  static int n, k;
  static String[] ps;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    ps = new String[n];
    for(int i = 0; i < n; i++){
      ps[i] = sc.next();
    }
    s = sc.next();

    int[] counts = new int[100 + 1];
    for(int i = 1; i <= 100; i++){
      for(int j = 0; j < n; j++){
        if(ps[j].length() == i){
          ++counts[i];
        }
      }
    }

    int len = s.length();
    int best = 0, worst = 0;
    for(int i = 1; i < len; i++){
      best += counts[i];
      worst += counts[i];
    }
    worst += counts[len] - 1;

    best += best / k * 5 + 1;
    worst += worst / k * 5 + 1;

    System.out.println(best + " " + worst);
  }
}
