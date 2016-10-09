import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n, m;
  static List< Integer > primes;
  static final int MAX = 1 << 17;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    StringBuilder sb = new StringBuilder();
    while(sc.hasNext()){
      n = sc.nextInt(); m = sc.nextInt();

      boolean flag = true;
      if(m == 0){
        flag = false;
      }
      else if(n == 0){
        flag = (m == 1);
      }
      else{
        eratosthenes();

        int[] countsM = new int[primes.size() + 1];
        int mm = m;

        for(int i = 0; i < primes.size(); i++){
          int p = primes.get(i);
          while(mm % p == 0){
            ++countsM[i];
            mm /= p;
          }
        }

        if(mm > 1){
          primes.add(mm);
          ++countsM[primes.size() - 1];
        }

        int[] countsNkai = new int[primes.size()];
        for(int i = 0; i < primes.size(); i++){
          int p = primes.get(i);
          int w = n;
          do{
            countsNkai[i] += w / p;
            w /= p;
          }while(w != 0);
        }

        // debug
        /*
        for(int i = 0; i < primes.size(); i++){
          if(countsM[i] != 0){
            System.out.println("countM[" + i + "] " + countsM[i]);
          }
        }
        for(int i = 0; i < primes.size(); i++){
          if(countsNkai[i] != 0){
            System.out.println("countNkai[" + i + "] " + countsNkai[i]);
          }
        }
        */

        for(int i = 0; i < primes.size(); i++){
          if(!(countsM[i] <= countsNkai[i])){
            flag = false; break;
          }
        }
      }

      if(flag){
        sb.append(m + " divides " + n + "!\n");
      }
      else{
        sb.append(m + " does not divide " + n + "!\n");
      }
    }

    System.out.print(sb);
  }

  private static void eratosthenes(){
    primes = new ArrayList< Integer >();
    boolean[] isNotPrime = new boolean[MAX + 1];

    for(int i = 2; i <= MAX; i++){
      if(!isNotPrime[i]){
        primes.add(i);
        for(int j = 2; i * j <= MAX; j++){
          isNotPrime[i * j] = true;
        }
      }
    }
  }
}
