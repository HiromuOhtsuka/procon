import java.util.Scanner;

public class Main {
  static int N, M;
  static char[][] hata;
  static char[][] monsyou;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    M = sc.nextInt(); N = sc.nextInt();
    hata = new char[M][N];
    sc.nextLine();
    for(int i = 0; i < M; i++){
      String line = sc.nextLine();
      for(int j = 0; j < N; j++){
        hata[i][j] = line.charAt(j);
      }
    }
    monsyou = new char[2][2];
    for(int i = 0; i < 2; i++){
      String line = sc.nextLine();
      for(int j = 0; j < 2; j++){
        monsyou[i][j] = line.charAt(j);
      }
    }

    int sum = 0;
    for(int i = 0; i < M; i++){
      for(int j = 0; j < N; j++){
        if(isMonsyou(j, i)){
          ++sum;
        }
      }
    }

    char[] changes = {'J', 'O', 'I'};
    int[] dx = {-1, 0, -1, 0}, dy = {-1, -1, 0, 0};
    int ans = sum;
    for(int i = 0; i < M; i++){
      for(int j = 0; j < N; j++){
        int pre = 0;
        for(int l = 0; l < 4; l++){
          if(isMonsyou(j + dx[l], i + dy[l])){
            ++pre;
          }
        }
        char mem = hata[i][j];
        for(int k = 0; k < changes.length; k++){
          hata[i][j] = changes[k];
          int count = 0;
          for(int l = 0; l < 4; l++){
            if(isMonsyou(j + dx[l], i + dy[l])){
              ++count;
            }
          }
          hata[i][j] = mem;
          ans = Math.max(ans, sum + (count - pre));
        }
      }
    }

    System.out.println(ans);
  }

  // left up
  static boolean isMonsyou(int x, int y){
    for(int i = 0; i < 2; i++){
      for(int j = 0; j < 2; j++){
        int nx = x + j, ny = y + i;
        if(!(0 <= nx && nx < N && 0 <= ny && ny < M)){
          return false;
        }
        if(hata[ny][nx] != monsyou[i][j]){
          return false;
        }
      }
    }
    return true;
  }
}
