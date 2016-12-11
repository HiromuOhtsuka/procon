import java.util.Scanner;

public class Main {
  static int h, w;
  static char[][] tab;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    h = sc.nextInt(); w = sc.nextInt();
    tab = new char[h][w];
    for(int i = 0; i < h; i++){
      tab[i] = sc.next().toCharArray();
    }

    char[][] tab2 = new char[2 * h][w];
    for(int i = 0; i < 2 * h; i++){
      for(int j = 0; j < w; j++){
        tab2[i][j] = tab[i / 2][j];
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 2 * h; i++){
      sb.append(tab2[i]); sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }
}
