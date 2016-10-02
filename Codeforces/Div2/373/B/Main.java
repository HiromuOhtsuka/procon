import java.util.Scanner;

public class Main {
  static int n;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.next();

    char[] str = s.toCharArray();

    int r = 0, b = 0;
    for(int i = 0; i < n; i++){
      if(str[i] == 'r'){
        ++r;
      }
      else{
        ++b;
      }
    }

    // start 'r'
    int cr = 0, cb = 0;
    for(int i = 0; i < n; i++){
      if(i % 2 == 0){
        if(str[i] == 'r'){
          ++cr;
        }
      }
      else{
        if(str[i] == 'b'){
          ++cb;
        }
      }
    }

    int count = Math.min(r - cr, b - cb) +
      Math.max(r - cr, b - cb) - Math.min(r - cr, b - cb);


    // start 'b'
    cr = 0; cb = 0;
    for(int i = 0; i < n; i++){
      if(i % 2 == 0){
        if(str[i] == 'b'){
          ++cb;
        }
      }
      else{
        if(str[i] == 'r'){
          ++cr;
        }
      }
    }

    count = Math.min(count, Math.min(r - cr, b - cb) +
      Math.max(r - cr, b - cb) - Math.min(r - cr, b - cb));

    System.out.println(count);
  }
}
