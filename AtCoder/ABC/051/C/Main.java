import java.util.Scanner;

public class Main{
  static int sx, sy;
  static int tx, ty;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    sx = sc.nextInt();
    sy = sc.nextInt();
    tx = sc.nextInt();
    ty = sc.nextInt();

    StringBuilder sb = new StringBuilder();
    for(int u = sy; u < ty; u++){
      sb.append("U");
    }
    for(int r = sx; r < tx; r++){
      sb.append("R");
    }
    for(int d = ty; d > sy; d--){
      sb.append("D");
    }
    for(int l = tx; l > sx; l--){
      sb.append("L");
    }
    sb.append("L");
    for(int u = sy; u < ty + 1; u++){
      sb.append("U");
    }
    for(int r = sx - 1; r < tx; r++){
      sb.append("R");
    }
    sb.append("D");
    sb.append("R");
    for(int d = ty; d > sy - 1; d--){
      sb.append("D");
    }
    for(int l = tx + 1; l > sx; l--){
      sb.append("L");
    }
    sb.append("U");

    System.out.println(sb);
  }
}
