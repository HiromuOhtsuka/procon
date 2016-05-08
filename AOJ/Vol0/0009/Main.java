import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    boolean[] table = new boolean[1000000];
    table[0] = table[1] = false;
    for(int i=0; i<1000000; i++){
      table[i] = true;
    }
    for(int num=2; num<1000000; num++){
      if(table[num]){
        for(int i=2; i<1000000/num; i++){
          table[num*i] = false;
        }
      }
    }
    for(int i=0; i<1000000; i++){
      if(table[i]){
        System.out.print(i + " ");
      }
    }
    Scanner scan = new Scanner(System.in);
    for(;;){
      if(scan.hasNext()){
        int n = scan.nextInt();
        int count = 0;
        for(int i=0; i<=n; i++){
          if(table[i]){
            count++;
          }
        }
        if(count >= 2){
          System.out.println(count - 2);
        }
      }
      else{
        break;
      }
    }
  }
}
