import java.util.Scanner;

public class Main {
  static int n;
  static boolean[] isHoriday;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    isHoriday = new boolean[366];
    int cur = 0;
    for(int i = 1; i <= 12; i++){
      int day = 31;
      switch(i){
        case 2: day = 29; break;
        case 4: case 6: case 9: case 11: day = 30; break;
      }
      for(int j = 0; j < day; j++){
        isHoriday[cur] = (cur % 7 == 0 || cur % 7 == 6);
        cur++;
      }
    }

    n = sc.nextInt();
    for(int i = 0; i < n; i++){
      String[] as = sc.next().split("/");
      int m = Integer.parseInt(as[0]), d = Integer.parseInt(as[1]);
      int num = no(m, d);
      if(!isHoriday[num]){
        isHoriday[num] = true;
      }
      else{
        while(num + 1 < 366 && isHoriday[num]){
          ++num;
        }
        isHoriday[num] = true;
      }
    }

    int max = 2;
    for(int s = 0; s < 366; s++){
      int t = s;
      while(t < 366 && isHoriday[t]){
        ++t;
      }
      max = Math.max(max, t - s);
    }

    System.out.println(max);
  }

  private static int no(int m, int d){
    int ret = 31 * (m - 1) + d - 1;

    for(int i = 1; i <= m - 1; i++){
      switch(i){
        case 2: ret -= 2; break;
        case 4: case 6: case 9: case 11: ret--; break;
      }
    }

    return ret;
  }
}
