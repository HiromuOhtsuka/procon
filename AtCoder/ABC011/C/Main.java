import java.util.Scanner;

public class Main {
  static int n;
  static int[] ng;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    ng = new int[3];
    for(int i = 0; i < 3; i++){
      ng[i] = sc.nextInt();
    }

    if(n == ng[0] || n == ng[1] || n == ng[2]){
      System.out.println("NO");
      return;
    }

    boolean ans = false;
    int sum = n, count = 0;
    while(sum >= 0){
      boolean flag = false;
      ++count;
      for(int i = 3; i >= 1; i--){
        int next = sum - i;
        if(next >= 0 && next != ng[0] && next != ng[1] && next != ng[2]){
          sum = next;
          flag = true;
          break;
        }
      }
      if(!flag){
        ans = false;
        break;
      }
      if(sum == 0){
        ans = (count <= 100);
        break;
      }
    }

    if(ans){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
