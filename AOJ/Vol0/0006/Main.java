import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    StringBuffer strb = new StringBuffer(scan.next());
    strb.reverse();
    System.out.println(strb);
  }
}
