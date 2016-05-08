import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    for(int i=0; i<n; i++){
      int a, b, c;
      a = scan.nextInt();
      b = scan.nextInt();
      c = scan.nextInt();
      boolean rightFlag = false;
      if(a*a == b*b+c*c){
        rightFlag = true;
      }
      else if(b*b == c*c+a*a){
        rightFlag = true;
      }
      else if(c*c == b*b+a*a){
        rightFlag = true;
      }
      if(rightFlag){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
      }
    }
  }
}
