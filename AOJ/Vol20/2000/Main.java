import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    final int Table_Max_Size = 1024;
    for(;;){
      int robo_x = 10; int robo_y = 10;
      int n = scan.nextInt();
      if(n==0){
        break;
      }
      boolean[][] table = new boolean[Table_Max_Size][Table_Max_Size];
      for(int i=0;i<Table_Max_Size;i++){
        for(int j=0;j<Table_Max_Size;j++){
          table[i][j] = false;
        }
      }
      for(int i=0;i<n;i++){
        int x = scan.nextInt();
        int y = scan.nextInt();
        table[y][x] = true;
      }
      int count = 0;
      int m = scan.nextInt();
      for(int i=0;i<m;i++){
        char angle = scan.next().charAt(0);
        int d = scan.nextInt();
        switch(angle){
          case 'N':
            for(int j=0;j<d;j++){
              robo_y++;
              if(table[robo_y][robo_x]){
                count++;
                table[robo_y][robo_x]=false;
              }
            }
            break;
          case 'S':
            for(int j=0;j<d;j++){
              robo_y--;
              if(table[robo_y][robo_x]){
                count++;
                table[robo_y][robo_x]=false;
              }
            }
            break;
          case 'E':
            for(int j=0;j<d;j++){
              robo_x++;
              if(table[robo_y][robo_x]){
                count++;
                table[robo_y][robo_x]=false;
              }
            }
            break;
          case 'W':
            for(int j=0;j<d;j++){
              robo_x--;
              if(table[robo_y][robo_x]){
                count++;
                table[robo_y][robo_x]=false;
              }
            }
            break;
        }
      }
      if(count==n){
        System.out.println("Yes");
      }
      else{
        System.out.println("No");
      }
    }
  }
}
