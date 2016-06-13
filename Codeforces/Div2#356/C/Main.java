import java.util.Scanner;

public class Main {
  static int[] p;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    p = new int[19];
    p[0] = 2;
    p[1] = 5; 
    p[2] = 3;
    p[3] = 7;
    p[4] = 11;
    p[5] = 13;
    p[6] = 17;
    p[7] = 19;
    p[8] = 23;
    p[9] = 29;
    p[10] = 31;
    p[11] = 37;
    p[12] = 41;
    p[13] = 43;
    p[14] = 47;
    p[15] = 4;
    p[16] = 9;
    p[17] = 25;
    p[18] = 49;

    int count = 0;
    for(int i = 0; i < 19; i++){
      System.out.println(p[i]);
      System.out.flush();

      String ret = sc.next();
      if("yes".equals(ret)){
        ++count;
      }

      if(count >= 2){
        System.out.println("composite");
        return;
      }
    }

    System.out.println("prime");
  }
}
