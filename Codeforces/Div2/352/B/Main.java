import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();
    String str = sc.nextLine();
    int kind = 0, change = 0;
    for(char al = 'a'; al <= 'z'; al++){
      int count = 0;
      for(int i = 0; i < n; i++){
        if(al == str.charAt(i)){
          ++count;
        }
      }
      if(count >= 1){
        ++kind;
        change += count - 1;
      }
    }

    if((26 - kind) >= change){
      System.out.println(change);
    }
    else{
      System.out.println(-1);
    }
  }
}
