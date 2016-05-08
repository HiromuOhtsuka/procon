import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int[] stack = new int[128];
    int sp = 0;
    while(scan.hasNext() && sp>=0){
      int n = scan.nextInt();
      if(n != 0){
        stack[sp++] = n;
      }
      else{
        sp--;
        if(sp>=0){
          System.out.println(stack[sp]);
        }
      }
    }
  }
}
