import java.util.Scanner;

public class Main {
  static int n;
  static String[] w;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    w = new String[n];
    for(int i = 0; i < n; i++){
      w[i] = sc.next();
    }

    int count = 0;
    for(int i = 0; i < n - 1; i++){
      if(w[i].matches("((TAKAHASHIKUN)|(Takahashikun)|(takahashikun))")){
        ++count;
      }
    }
    if(w[n - 1].matches("((TAKAHASHIKUN)|(Takahashikun)|(takahashikun))\\.")){
      ++count;
    }

    System.out.println(count);
  }
}
