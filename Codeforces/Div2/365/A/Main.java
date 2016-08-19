import java.util.Scanner;

public class Main {
  static int n;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n]; b = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();  b[i] = sc.nextInt();
    }

    int countA = 0, countB = 0;
    for(int i = 0; i < n; i++){
      if(a[i] < b[i]){
        ++countB;
      }
      else if(a[i] > b[i]){
        ++countA;
      }
    }

    if(countA > countB){
      System.out.println("Mishka");
    }
    else if(countA < countB){
      System.out.println("Chris");
    }
    else{
      System.out.println("Friendship is magic!^^");
    }
  }
}
