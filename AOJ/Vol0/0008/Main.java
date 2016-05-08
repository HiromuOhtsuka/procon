import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    for(;;){
      if(scan.hasNext()){
        int n = scan.nextInt();
        int count = 0;
        // 10^4
        for(int i0=0; i0<=9; i0++){
          for(int i1=0; i1<=9; i1++){
            for(int i2=0; i2<=9; i2++){
              for(int i3=0; i3<=9; i3++){
                if(i0+i1+i2+i3 == n){
                  count++;
                }
              }
            }
          }
        }
        System.out.println(count);
      }
      else{
        break;
      }
    }
  }
}
