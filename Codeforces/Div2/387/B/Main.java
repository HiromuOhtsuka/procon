import java.util.Scanner;

public class Main {
  static int n;
  static char[] str;

  static final int A = 0, C = 1, G = 2, T = 3;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    str = sc.next().toCharArray();

    if(n % 4 != 0){
      System.out.println("===");
      return;
    }

    int k = n / 4;

    int[] counts = new int[4];
    for(int i = 0; i < n; i++){
      switch(str[i]){
        case 'A': counts[A]++;  break;
        case 'C': counts[C]++;  break;
        case 'G': counts[G]++;  break;
        case 'T': counts[T]++;  break;
      }
    }

    for(int i = 0; i < 4; i++){
      if(counts[i] > k){
        System.out.println("===");
        return;
      }
    }

    for(int i = 0; i < n; i++){
      if(str[i] == '?'){
        for(int j = 0; j < 4; j++){
          if(counts[j] < k){
            switch(j){
              case A: str[i] = 'A'; break;
              case C: str[i] = 'C'; break;
              case G: str[i] = 'G'; break;
              case T: str[i] = 'T'; break;
            }
            counts[j]++;
            break;
          }
        }
      }
    }

    System.out.println(str);
  }
}
