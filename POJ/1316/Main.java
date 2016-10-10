public class Main {
  static final int MAX = 10000;
  static boolean[] flag;

  public static void main(String[] args){
    flag = new boolean[MAX + 1];

    for(int x = 1; x <= MAX; x++){
      int y = d(x);
      if(y <= MAX){
        flag[y] = true;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int x = 1; x <= MAX; x++){
      if(!flag[x]){
        sb.append(x + "\n");
      }
    }

    System.out.print(sb);
  }

  private static int d(int n){
    String s = Integer.toString(n);
    int sum = n, len = s.length();
    for(int i = 0; i < len; i++){
      sum += s.charAt(i) - '0';
    }
    return sum;
  }
}
