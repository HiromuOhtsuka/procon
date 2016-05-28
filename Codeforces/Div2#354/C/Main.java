import java.util.Scanner;

public class Main {
  static int n, k;
  static String str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    sc.nextLine();
    str = sc.nextLine();

    int max = 1;
    char[] ch = str.toCharArray();
    int count = 0, t = 0;
    for(int i = 0; i < n; i++){
      if(ch[i] != 'a'){
        ++count;
      }
      while(t <= i && count > k){
        if(ch[t] != 'a'){
          --count;
        }
        ++t;
      }
      max = Math.max(max, i - t + 1);
    }
    count = t = 0;
    for(int i = 0; i < n; i++){
      if(ch[i] != 'b'){
        ++count;
      }
      while(t <= i && count > k){
        if(ch[t] != 'b'){
          --count;
        }
        ++t;
      }
      max = Math.max(max, i - t + 1);
    }

    System.out.println(max);
  }
}
