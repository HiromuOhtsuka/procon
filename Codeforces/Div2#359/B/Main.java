import java.util.Scanner;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    for(;;){
      int l = -1, r = -1;
      boolean flag = false;
      for(int i = 0; i < n - 1; i += 2){
        if(a[i] > a[i + 1]){
          if(r != -1 && r == i - 1){
            r = i + 1;
          }
          else{
            l = i;  r = i + 1;
          }
          flag = true;
          int tmp = a[i];
          a[i] = a[i + 1];
          a[i + 1] = tmp;
        }
        else if(l != -1 && r != -1){
          System.out.println((l + 1) + " " + (r + 1));
          l = r = -1;
        }
      }

      if(l != -1 && r != -1){
        System.out.println((l + 1) + " " + (r + 1));
      }

      l = r = -1;
      for(int i = 1; i < n - 1; i += 2){
        if(a[i] > a[i + 1]){
          if(r != -1 && r == i - 1){
            r = i + 1;
          }
          else{
            l = i;  r = i + 1;
          }
          flag = true;
          int tmp = a[i];
          a[i] = a[i + 1];
          a[i + 1] = tmp;
        }
        else if(l != -1 && r != -1){
          System.out.println((l + 1) + " " + (r + 1));
          l = r = -1;
        }
      }

      if(l != -1 && r != -1){
        System.out.println((l + 1) + " " + (r + 1));
      }

      if(!flag){
        break;
      }
    }
  }
}
