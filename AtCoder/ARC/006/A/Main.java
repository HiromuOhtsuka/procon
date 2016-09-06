import java.util.Scanner;

public class Main {
  static int b;
  static int[] e, l;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    e = new int[6];
    for(int i = 0; i < 6; i++){
      e[i] = sc.nextInt();
    }
    b = sc.nextInt();
    l = new int[6];
    for(int i = 0; i < 6; i++){
      l[i] = sc.nextInt();
    }

    boolean[] ml = new boolean[10];
    for(int i = 0; i < 6; i++){
      ml[l[i]] = true;
    }

    int count = 0;
    for(int i = 0; i < 6; i++){
      if(ml[e[i]]){
        ++count;
      }
    }

    int ans = 0;
    if(count == 6){
      ans = 1;
    }
    else if(count == 5 && ml[b]){
      ans = 2;
    }
    else if(count == 5){
      ans = 3;
    }
    else if(count == 4){
      ans = 4;
    }
    else if(count == 3){
      ans = 5;
    }

    System.out.println(ans);
  }
}
