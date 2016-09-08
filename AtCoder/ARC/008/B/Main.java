import java.util.Scanner;

public class Main {
  static int n, m;
  static String name, kit;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    name = sc.next(); kit = sc.next();

    int[] needs = new int[26], counts = new int[26];
    for(int i = 0; i < m; i++){
      ++counts[kit.charAt(i) - 'A'];
    }
    for(int i = 0; i < n; i++){
      ++needs[name.charAt(i) - 'A'];
    }

    int ans = -1;
    for(int i = 0; i < 26; i++){
      if(needs[i] >= 1 && counts[i] <= 0){
        System.out.println(-1);
        return;
      }
      if(counts[i] == 0){
        continue;
      }
      int tmp = (needs[i] % counts[i] == 0 ?
          needs[i] / counts[i] : needs[i] / counts[i] + 1);
      ans = Math.max(ans, tmp);
    }

    System.out.println(ans);
  }
}
