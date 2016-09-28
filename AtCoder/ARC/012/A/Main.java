import java.util.Scanner;

public class Main {
  static String day;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    day = sc.next();

    int r = 0;
    if("Sunday".equals(day)){
      r = 0;
    }
    else if("Monday".equals(day)){
      r = 5;
    }
    else if("Tuesday".equals(day)){
      r = 4;
    }
    else if("Wednesday".equals(day)){
      r = 3;
    }
    else if("Thursday".equals(day)){
      r = 2;
    }
    else if("Friday".equals(day)){
      r = 1;
    }
    else if("Saturday".equals(day)){
      r = 0;
    }

    System.out.println(r);
  }
}
