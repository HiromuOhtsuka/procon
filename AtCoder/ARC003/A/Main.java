import java.util.Scanner;

public class Main {
  static int n;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.next();

    int sum = 0;
    for(int i = 0; i < n; i++){
      switch(s.charAt(i)){
        case 'A' : sum += 4; break;
        case 'B' : sum += 3; break;
        case 'C' : sum += 2; break;
        case 'D' : sum += 1; break;
      }
    }

    double ave = (double)sum / n;

    System.out.println(ave);
  }
}
