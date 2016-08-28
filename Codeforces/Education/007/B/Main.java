import java.util.Scanner;

public class Main {
  static long hh, mm, a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String var = sc.next();
    String[] vars = var.split(":");
    hh = Integer.parseInt(vars[0]); mm = Integer.parseInt(vars[1]);
    a = sc.nextLong();

    int d = 0;
    if(mm + a >= 60){
      ++d;
      d += (mm + a - 60) / 60;
    }
    hh = (hh + d) % 24;
    mm = (mm + a) % 60;

    if(hh / 10 >= 1){
      System.out.print(hh);
    }
    else{
      System.out.print("0" + hh);
    }
    System.out.print(":");
    if(mm / 10 >= 1){
      System.out.print(mm);
    }
    else{
      System.out.print("0" + mm);
    }
    System.out.println();
  }
}
