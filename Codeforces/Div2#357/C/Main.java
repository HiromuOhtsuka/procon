import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n;
  static List< String > ans;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    ans = new ArrayList< String >();

    n = sc.nextInt();

    PriorityQueue< Integer > pq = new PriorityQueue< Integer >();
    for(int i = 0; i < n; i++){
      int opNum = 0;
      String op = sc.next();
      if("insert".equals(op) || "getMin".equals(op)){
        opNum = sc.nextInt();
      }
      if("insert".equals(op)){
        pq.offer(opNum);
        ans.add(op + " " + opNum);
      }
      if("removeMin".equals(op)){
        if(pq.isEmpty()){
          ans.add("insert 1");
          ans.add("removeMin");
        }
        else{
          pq.poll();
          ans.add("removeMin");
        }
      }

      if("getMin".equals(op)){
        if(!pq.contains(opNum)){
          pq.offer(opNum);
          ans.add("insert " + opNum);
        }
        while(pq.peek() != opNum){
          pq.poll();
          ans.add("removeMin");
        }
        ans.add("getMin " + opNum);
      }
    }

    System.out.println(ans.size());
    for(int i = 0; i < ans.size(); i++){
      System.out.println(ans.get(i));
    }
  }
}
