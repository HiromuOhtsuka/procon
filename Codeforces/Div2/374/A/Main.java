import java.util.Scanner;

public class Main {
  static int n;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.next();

    char[] str = s.toCharArray();

    int[] counts = new int[n];
    int sp = 0, i = 0;
    while(i < n){
      int j = i, count = 0;
      while(j < n && str[j] == 'B'){
        ++count; ++j;
      }
      if(count >= 1){
        counts[sp++] = count;
      }
      i = j + 1;
    }

    System.out.println(sp);
    for(int j = 0; j < sp; j++){
      System.out.print(counts[j] + ((j == sp - 1 ?  "\n" : " ")));
    }
  }
}
