import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  // 現在の列
  static int base;

  static class Wall implements Comparable< Wall > {
    int x1, x2;

    Wall(int x1, int x2){
      this.x1 = x1;
      this.x2 = x2;
    }

    // 現在の列からの長さを比較する。
    public int compareTo(Wall w){
      return (this.x2 - base) - (w.x2 - base);
    }
  }

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int T = scan.nextInt();
    for(int t = 0; t < T; t++){
      // input
      int N = scan.nextInt(), K = scan.nextInt();
      int row = 0;
      List< Wall > walls = new ArrayList< Wall >();
      for(int i = 0; i < N; i++){
        int x1 = scan.nextInt(), y1 = scan.nextInt(), 
          x2 = scan.nextInt(), y2 = scan.nextInt();
        walls.add(new Wall(Math.min(x1, x2), Math.max(x1, x2)));
        row = Math.max(row, Math.max(x1, x2));
      }

      // count
      int count = 0;
      List< Wall > list = new ArrayList< Wall >();
      for(int i = 0; i <= row; i++){
        // i - 1列以下にある壁を削除。 
        for(int j = 0; j < list.size(); j++){
          if(list.get(j).x2 <= i - 1){
            list.remove(j);
          }
        }
        // i列目の壁を追加。
        for(int j = 0; j < walls.size(); j++){
          if(walls.get(j).x1 <= i && walls.get(j).x2 >= i
              && !list.contains(walls.get(j))){
            list.add(walls.get(j));
          }
        }
        // 現在の列から見て最長の長さの壁を，
        // 壁の個数がKより大きい分だけ取り除く。
        base = i;
        Collections.sort(list);
        if(list.size() > K){
          for(int j = 0, tmp = list.size() - K; j < tmp; j++){
            walls.remove(list.get(list.size() - 1));
            list.remove(list.size() - 1);
            ++count;
          }
        }
      }

      System.out.println(count);
    }
  }
}

