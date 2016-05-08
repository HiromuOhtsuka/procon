import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Main {
  class Table {
    int[][] a;
    int x0, y0;

    Table(){
      this.a = new int[2][4];
    }

    Table(Table table){
      this.a = new int[2][4];
      for(int i = 0; i < 2; i++){
        for(int j = 0; j < 4; j++){
          this.a[i][j] = table.a[i][j];
        }
      }
      this.x0 = table.x0;
      this.y0 = table.y0;
    }


    @Override
    public boolean equals(Object obj){
      if(!(obj instanceof Table)){
        return false;
      }
      if(obj == this){
        return true;
      }
      Table t = (Table)obj;
      for(int i = 0; i < 2; i++){
        for(int j = 0; j < 4; j++){
          if(this.a[i][j] != t.a[i][j]){
            return false;
          }
        }
      }
      return true;
    }

    @Override
    public int hashCode(){
      return 42;
    }

  }

  class Pair {
    Table table;
    int d;

    Pair(Table table, int d){
      this.table = table;
      this.d = d;
    }
  }

  boolean isComplete(Table table){
    int count = 0;
    for(int i = 0; i < 2; i++){
      for(int j = 0; j < 4; j++){
        if(table.a[i][j] != count){
          return false;
        }
        ++count;
      }
    }
    return true;
  }


  private int search(Table s){
    final int[] dx = new int[]{-1, 0, 0, 1};
    final int[] dy = new int[]{0, -1, 1, 0};
    Queue< Pair > que = new LinkedList< Pair >();
    Map< Table, Boolean > V = new HashMap< Table, Boolean >();

    que.offer(new Pair(s, 0));
    while(!que.isEmpty()){
      Pair p = que.poll();
      Table table = p.table;
      int d = p.d;
      if(isComplete(table)){
        return d;
      }
      Boolean b = V.get(table);
      if(b != null && b){
        continue;
      }
      V.put(table, true);
      for(int i = 0; i < 4; i++){
        Table nt = new Table(table);
        int x = table.x0 + dx[i], y = table.y0 + dy[i];
        if(0 <= x && x < 4 && 0 <= y && y < 2){
          nt.a[nt.y0][nt.x0] = nt.a[y][x];
          nt.a[y][x] = 0;
          nt.x0 = x;  nt.y0 = y;
          que.offer(new Pair(nt, d + 1));
        }
      }
    }

    return -1;
  }

  public static void main(String[] args){
    new Main();
  }

  public Main(){
    Scanner scan = new Scanner(System.in);
    while(scan.hasNext()){
      Table table = new Table();
      for(int i = 0; i < 2; i++){
        for(int j = 0; j < 4; j++){
          int n = scan.nextInt();
          table.a[i][j] = n;
          if(n == 0){
            table.x0 = j;
            table.y0 = i;
          }
        }
      }
      System.out.println(search(table));
    }
  }
}
