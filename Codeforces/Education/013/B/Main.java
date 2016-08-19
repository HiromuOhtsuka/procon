import java.util.Scanner;

public class Main {
  static int y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    y = sc.nextInt();

    long yy = y + 1;
    long count = 1;
    if(!isLeapYear(y)){
      while(!((count % 7) == 0 && !isLeapYear(yy))){
        if(isLeapYear(yy)){
          ++count;
        }
        ++count;  ++yy;
      }
    }
    else{
      ++count;
      while(!((count % 7) == 0 && isLeapYear(yy))){
        if(isLeapYear(yy)){
          ++count;
        }
        ++count;  ++yy;
      }
    }

    System.out.println(yy);
  }

  private static boolean isLeapYear(long year){
    if(year % 4 == 0){
      if(year % 100 == 0){
        if(year % 400 == 0){
          return true;
        }
        else{
          return false;
        }
      }
      else{
        return true;
      }
    }
    else{
      return false;
    }
  }
}
