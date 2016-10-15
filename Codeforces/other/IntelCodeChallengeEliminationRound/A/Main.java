import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static int hh, mm;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    String[] as = sc.next().split(":");
    hh = Integer.parseInt(as[0]); mm = Integer.parseInt(as[1]);

    StringBuilder sb = new StringBuilder();
    if(check(hh, mm, n)){
      if(hh < 10){
        sb.append("0");
      }
      sb.append(hh + ":");
      if(mm < 10){
        sb.append("0");
      }
      sb.append(mm);
      System.out.println(sb);
      return;
    }

    int min = INF, mi = 0, mj = 0;
    if(n == 12){
      for(int i = 1; i <= 12; i++){
        for(int j = 0; j < 60; j++){
          int d = diff(hh, i) + diff(mm, j);
          if(min > d){
            min = d;  mi = i; mj = j;
          }
        }
      }
    }
    else{
      for(int i = 0; i < 24; i++){
        for(int j = 0; j < 60; j++){
          int d = diff(hh, i) + diff(mm, j);
          if(min > d){
            min = d;  mi = i; mj = j;
          }
        }
      }
    }

    if(mi < 10){
      sb.append("0");
    }
    sb.append(mi + ":");
    if(mj < 10){
      sb.append("0");
    }
    sb.append(mj);

    System.out.println(sb);
  }

  private static boolean check(int hh, int mm, int n){
    if(n == 12){
      return 1 <= hh && hh <= 12 && mm <= 59;
    }
    else{
      return 0 <= hh && hh <= 23 && mm <= 59;
    }
  }

  private static int diff(int a, int b){
    int count = 0;
    if(a % 10 != b % 10){
      ++count;
    }
    if(a / 10 != b / 10){
      ++count;
    }
    return count;
  }
}
