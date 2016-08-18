import java.util.Scanner;

public class Main {
  static int y, m, d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String line = sc.next();
    String[] tmps = line.split("/");

    y = Integer.parseInt(tmps[0]);
    m = Integer.parseInt(tmps[1]);
    d = Integer.parseInt(tmps[2]);

    for(;;){
      if(y % m == 0 && (y / m) % d == 0){
        break;
      }
      while(y % m != 0){
        if(m + 1 == 13){
          m = 1;
          ++y;
          d = 1;
        }
        else{
          ++m;
          d = 1;
        }
      }
      while((y / m) % d != 0){
        boolean flag = false;
        switch(m){
          case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            if(d + 1 == 32){
              d = 1;
              flag = true;
            }
            else{
              ++d;
            }
            break;
          case 4: case 6: case 9: case 11:
            if(d + 1 == 31){
              d = 1;
              flag = true;
            }
            else{
              ++d;
            }
            break;
          case 2:
            if(urue(y)){
              if(d + 1 == 30){
                d = 1;
                flag = true;
              }
              else{
                ++d;
              }
            }
            else{
              if(d + 1 == 29){
                d = 1;
                flag = true;
              }
              else{
                ++d;
              }
            }
            break;
        }
        if(flag){
          if(m + 1 == 13){
            m = 1;
            ++y;
          }
          else{
            ++m;
          }
          d = 1;
          break;
        }
      }
    }

    System.out.print(y);
    if(m < 10){
      System.out.print("/0" + m);
    }
    else{
      System.out.print("/" + m);
    }
    if(d < 10){
      System.out.println("/0" + d);
    }
    else{
      System.out.println("/" + d);
    }

  }

  private static boolean urue(int y){
    if(y % 400 == 0){
      return true;
    }
    else if(y % 100 == 0){
      return false;
    }
    else if(y % 4 == 0){
      return true;
    }
    else{
      return false;
    }
  }
}
