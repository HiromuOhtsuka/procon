import java.util.Scanner;

public class Sub {
  static long a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextLong();  b = sc.nextLong();

    if(b > 10000){
      return;
    }

    long count = 0;
    for(long s = a; s <= b; s++){
      String str = Long.toString(s);
      for(int i = 0; i < str.length(); i++){
        if(str.charAt(i) == '4' || str.charAt(i) == '9'){
          ++count;
          break;
        }
      }
    }

    System.out.println(count);
  }
}
