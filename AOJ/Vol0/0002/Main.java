import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    for(;;){
      if(scan.hasNext()){
        int a = scan.nextInt();
        int b = scan.nextInt();
        int sum = a+b;
        int digit = 1;
        while(sum/10 != 0){
          sum /= 10;
          digit++;
        }
        System.out.println(digit);
      }
      else{
        break;
      }
    }
  }
}
