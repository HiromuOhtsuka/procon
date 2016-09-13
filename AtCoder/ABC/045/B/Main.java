import java.util.Scanner;

public class Main {
  static String sa, sb, sc;

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);

    sa = scn.next(); sb = scn.next(); sc = scn.next();
    int[] sp = new int[3];
    char next = 'a';
    boolean con = true;
    sp[0] = sp[1] = sp[2] = -1;
    while(con){
      switch(next){
        case 'a':
          if(sp[0] + 1 < sa.length()){
            next = sa.charAt(++sp[0]);
          }
          else{
            con = false;
          }
          break;
        case 'b':
          if(sp[1] + 1 < sb.length()){
            next = sb.charAt(++sp[1]);
          }
          else{
            con = false;
          }
          break;
        case 'c':
          if(sp[2] + 1 < sc.length()){
            next = sc.charAt(++sp[2]);
          }
          else{
            con = false;
          }
          break;
      }
    }

    if(next == 'a'){
      System.out.println("A");
    }
    else if(next == 'b'){
      System.out.println("B");
    }
    else{
      System.out.println("C");
    }
  }
}
