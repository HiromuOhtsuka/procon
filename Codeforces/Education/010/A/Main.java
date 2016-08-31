import java.util.Scanner;

public class Main {
  static int h1, h2, a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    h1 = sc.nextInt();  h2 = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt();

    int ans = 0;
    int h = h1;
    if(h + 8 * a >= h2){
      ans = 0;
    }
    else if(a <= b){
      ans = -1;
    }
    else{
      int count = 0;
      for(;;){
        h += 8 * a;
        if(h >= h2){
          break;
        }
        h -= 12 * b;
        h += 4 * a;
        ++count;
        if(h >= h2){
          break;
        }
      }
      ans = count;
    }

    System.out.println(ans);
  }
}
