import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    for(;;){
      if(scan.hasNext()){
        int a, b, c, d, e, f;
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        d = scan.nextInt();
        e = scan.nextInt();
        f = scan.nextInt();

        int g = a*e-b*d;
        double x = (double)(e*c-b*f)/g;
        double y = (double)(-d*c+a*f)/g;
        if(x == -0.0){
          x = 0.0;
        }
        if(y == -0.0){
          y = 0.0;
        }
        System.out.printf("%.3f %.3f\n", x, y);
      }
      else{
        break;
      }
    }
  }
}

