import java.util.Scanner;

public class Main{
  static int n;
  static String[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new String[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.next();
    }

    int sum = 0;
    for(int i = 0; i < n; i++){
      if("Tetrahedron".equals(a[i])){
        sum += 4;
      }
      else if("Cube".equals(a[i])){
        sum += 6;
      }
      else if("Octahedron".equals(a[i])){
        sum += 8;
      }
      else if("Dodecahedron".equals(a[i])){
        sum += 12;
      }
      else if("Icosahedron".equals(a[i])){
        sum += 20;
      }
    }

    System.out.println(sum);
  }
}
