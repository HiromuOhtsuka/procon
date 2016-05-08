import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    for(;;){
      int n = scan.nextInt();
      if(n == 0) break;
      int om = scan.nextInt();
      int[] ox = new int[om], oy = new int[om];
      for(int i=0; i<om; i++){
        ox[i] = scan.nextInt(); oy[i] = scan.nextInt();
      }
      Line o = new Line(ox, oy, om);
      Line[] lines = new Line[n];
      for(int i=0; i<n; i++){
        int m = scan.nextInt();
        int[] x = new int[m], y = new int[m];
        for(int j=0; j<m; j++){
          x[j] = scan.nextInt(); y[j] = scan.nextInt();
        }
        lines[i] = new Line(x, y, m);
      }
      for(int j=0; j<n; j++){
        if(o.equals(lines[j])){
          System.out.println(j+1);
        }
      }
      System.out.println("+++++");
    }
  }
}

class Line {
  int[] x, y;
  int m;

  Line(int[] x, int[] y, int m){
    this.m = m;
    this.x = new int[this.m]; this.y = new int[this.m];
    for(int i=0; i<this.m; i++){
      this.x[i] = x[i];
      this.y[i] = y[i];
    }
  }

  public void lorate(){
    for(int i=0; i<this.m; i++){
      int tmp = this.x[i];
      this.x[i] = -this.y[i];
      this.y[i] = tmp;
    }
  }

  public Line decentrate(int x, int y){
    int[] xc = new int[this.m], yc = new int[this.m];
    for(int i=0; i<this.m; i++){
      xc[i] = this.x[i] - x;
      yc[i] = this.y[i] - y;
    }
    return new Line(xc, yc, this.m);
  }

  public boolean judge(Line l){
    if(this.m != l.m) return false;
    boolean flag = true;
    for(int i=0; i<this.m; i++){
      if(this.x[i] != l.x[i] || this.y[i] != l.y[i]){
        flag = false;
        break;
      }
    }
    if(flag) return true;
    flag = true;
    for(int i=this.m-1; i>=0; i--){
      if(this.x[i] != l.x[l.m-i-1] || this.y[i] != l.y[l.m-i-1]){
        flag = false;
        break;
      }
    }
    if(flag) return true;
    return false;
  }

  public boolean equals(Line l){
    if(this.m != l.m) return false;
    for(int i=0; i<this.m; i++){
      Line tmp = this.decentrate(this.x[i], this.y[i]);
      for(int j=0; j<l.m; j++){
        Line tmpl = l.decentrate(l.x[j], l.y[j]);
        boolean flag = tmp.judge(tmpl);
        if(flag) return true;
        tmp.lorate();
        flag = tmp.judge(tmpl);
        if(flag) return true;
        tmp.lorate();
        flag = tmp.judge(tmpl);
        if(flag) return true;
        tmp.lorate();
        flag = tmp.judge(tmpl);
        if(flag) return true;
      }
    }
    return false;
  }

}
