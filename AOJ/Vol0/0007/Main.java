import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int m = 100000;
    int n = scan.nextInt();
    for(int i=0; i<n; i++){
      m = (int)((double)m * 1.05);
      if(m%1000 > 0){
        m += 1000;
        m -= m%1000;
      }
    }
    System.out.println(m);
  }
}
