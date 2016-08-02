import java.util.Scanner;

public class Main {
  static int n, d, k;
  static Interval[] lr;
  static int[] s, t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); d = sc.nextInt(); k = sc.nextInt();
    lr = new Interval[d];
    for(int i = 0; i < d; i++){
      int l = sc.nextInt(), r = sc.nextInt();
      lr[i] = new Interval(l, r);
    }
    s = new int[k]; t = new int[k];
    for(int i = 0; i < k; i++){
      s[i] = sc.nextInt(); t[i] = sc.nextInt();
    }

    for(int i = 0; i < k; i++){
      boolean flag = (s[i] < t[i]);
      int at = s[i];
      Interval now = new Interval(s[i], s[i]);
      for(int j = 0; j <= d; j++){
        if(now.in(t[i])){
          System.out.println(j);
          break;
        }
        if(Interval.isCross(now, lr[j])){
          if(flag){
            if(at < lr[j].t){
              at = lr[j].t;
              now = lr[j];
            }
          }
          else{
            if(at > lr[j].s){
              at = lr[j].s;
              now = lr[j];
            }
          }
        }
      }
    }
  }

  static class Interval {
    int s, t;

    Interval(int s, int t){
      this.s = s; this. t = t;
    }

    boolean in(int v){
      return s <= v && v <= t;
    }

    static boolean isCross(Interval i1, Interval i2){
      return !(i1.t < i2.s || i2.t < i1.s);
    }
  }
}
