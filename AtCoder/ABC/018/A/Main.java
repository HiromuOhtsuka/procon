import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
    Pair[] p = new Pair[3];
    p[0] = new Pair(a, 0);  p[1] = new Pair(b, 1);  p[2] = new Pair(c, 2);
    Arrays.sort(p);

    for(int i = 0; i < 3; i++){
      if(p[i].t == 0){
        System.out.println(3 - i);
        break;
      }
    }
    for(int i = 0; i < 3; i++){
      if(p[i].t == 1){
        System.out.println(3 - i);
        break;
      }
    }
    for(int i = 0; i < 3; i++){
      if(p[i].t == 2){
        System.out.println(3 - i);
        break;
      }
    }
  }

  static class Pair implements Comparable< Pair > {
    int s, t;

    Pair(int s, int t){
      this.s = s; this.t = t;
    }

    @Override
    public int compareTo(Pair p){
      if(s == p.s){
        return t - p.t;
      }
      return s - p.s;
    }
  }

}
