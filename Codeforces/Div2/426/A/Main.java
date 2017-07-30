import java.util.Scanner;

public class Main{
  static char s, t;
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next().toCharArray()[0];
    t = sc.next().toCharArray()[0];
    n = sc.nextInt();

    int posS1 = 0;
    switch(s){
      case 'v' : posS1 = 0; break;
      case '<' :  posS1 = 1; break;
      case '^' : posS1 = 2; break;
      case '>' : posS1 = 3; break;
    }
    int posT1 = 0;
    switch(t){
      case 'v' : posT1 = 0; break;
      case '<' :  posT1 = 1; break;
      case '^' : posT1 = 2; break;
      case '>' : posT1 = 3; break;
    }

    int posS2 = 0;
    switch(s){
      case 'v' : posS2 = 0; break;
      case '>' :  posS2 = 1; break;
      case '^' : posS2 = 2; break;
      case '<' : posS2 = 3; break;
    }
    int posT2 = 0;
    switch(t){
      case 'v' : posT2 = 0; break;
      case '>' :  posT2 = 1; break;
      case '^' : posT2 = 2; break;
      case '<' : posT2 = 3; break;
    }

    if((posS1 + n) % 4 == posT1 && (posS2 + n) % 4 == posT2){
      System.out.println("undefined");
    }
    else if((posS1 + n) % 4 == posT1){
      System.out.println("cw");
    }
    else{
      System.out.println("ccw");
    }
  }
}
