mport java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    for(;;){
      int e = scan.nextInt();
      if(e == 0){
        break;
      }
      int m = e;
      int x, y, z;
      for(z = 0 ;z*z*z <= e; z++){
        for(y = 0 ; y*y + z*z*z <= e; y++){
          x = e - y*y - z*z*z;
          if(m > x + y + z){
            m = x + y + z;
          }
        }
      }
      System.out.println(m);
    }
  }
}
