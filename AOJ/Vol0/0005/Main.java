import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    for(;;){
      if(scan.hasNext()){
        int a, b;
        a = scan.nextInt();
        b = scan.nextInt();
        int g, l;
        g = GCD(a, b);
        l =a / g * b;    // order
        System.out.println(g + " " + l);
      }
      else{
        break;
      }
    }
  }

  private static int GCD(int a, int b){
    int s = (a < b) ? a : b;
    int l = (a >= b) ? a : b;
    for(int i=s; i>1; i--){
      if(l%i == 0 && s%i == 0){
        return i;
      }
    }
    return 1;
  }
}
