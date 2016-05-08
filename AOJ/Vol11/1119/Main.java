import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    for(int i=0; i<n; i++){
      int dx, dy, x, y, max_x, max_y;
      x = y = max_x = max_y = 0;
      do{
        dx = scan.nextInt();
        dy = scan.nextInt();
        x += dx; y += dy;
        if(x*x + y*y > max_x*max_x + max_y*max_y){
          max_x = x; max_y = y;
        }
        else if(x*x + y*y == max_x*max_x + max_y*max_y){
          if(x > max_x){
            max_x = x; max_y = y;
          }
        }
      }while(dx != 0 || dy != 0);
      System.out.println(max_x + " " + max_y);
    }
  }
}
