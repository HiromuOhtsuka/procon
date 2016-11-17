import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n, k;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    k = sc.nextInt();
    b = new int[k];
    for(int i = 0; i < k; i++){
      b[i] = sc.nextInt();
    }

    int s = 0, i = 0, count = 0;
    int[] pos = new int[n - 1];
    char[] d = new char[n - 1];
    while(s < n){
      if(i >= k){
        i = k + 1;
        break;
      }
      int t = s, sum = 0;
      while(t < n && sum < b[i]){
        sum += a[t];
        ++t;
      }
      if(sum != b[i]){
        break;
      }
      // s-t solution
      Integer[][] ans = greedy(s, t, i);
      if(ans == null){
        break;
      }
      for(Integer[] a : ans){
        pos[count] = a[0];
        d[count] = (a[1] == 0 ? 'L' : 'R');
        ++count;
      }
      s = t;
      ++i;
    }

    if(i == k){
      System.out.println("YES");
      StringBuilder sb = new StringBuilder();
      for(int j = 0; j < count; j++){
        sb.append(pos[j] + " " + d[j] + System.lineSeparator());
      }
      System.out.print(sb);
    }
    else{
      System.out.println("NO");
    }
  }

  private static Integer[][] greedy(int s, int t, int m){
    List< Integer[] > list = new ArrayList< Integer[] >();
    int size = t - s;
    int i = s, j = s + 1, k = s + 2;
    int count = 0;
    while(size >= 3){
      ++count;
      if(count > n * n){
        return null;
      }
      if((a[i] < a[j] || a[i] > a[j]) &&
          (a[j] < a[k] || a[j] > a[k])){
        if(a[i] + a[j] == a[k]){
          if(a[j] < a[k]){
            list.add(new Integer[]{rank(s, t, k) + m, 0});
          }
          else{
            list.add(new Integer[]{rank(s, t, j) + m, 1});
          }
          a[j] = a[j] + a[k];
          a[k] = 0;
          --size;
        }
        else if(a[j] + a[k] == a[i]){
          if(a[i] < a[j]){
            list.add(new Integer[]{rank(s, t, j) + m, 0});
          }
          else{
            list.add(new Integer[]{rank(s, t, i) + m, 1});
          }
          a[j] = a[i] + a[j];
          a[i] = 0;
          --size;
        }
        else{
          if(a[i] < a[j]){
            list.add(new Integer[]{rank(s, t, j) + m, 0});
          }
          else{
            list.add(new Integer[]{rank(s, t, i) + m, 1});
          }
          a[j] = a[i] + a[j];
          a[i] = 0;
          --size;
        }
      }
      else if(a[i] < a[j] || a[i] > a[j]){
        if(a[i] < a[j]){
          list.add(new Integer[]{rank(s, t, j) + m, 0});
        }
        else{
          list.add(new Integer[]{rank(s, t, i) + m, 1});
        }
        a[j] = a[i] + a[j];
        a[i] = 0;
        --size;
      }
      else if(a[j] < a[k] || a[j] > a[k]){
        if(a[j] < a[k]){
          list.add(new Integer[]{rank(s, t, k) + m, 0});
        }
        else{
          list.add(new Integer[]{rank(s, t, j) + m, 1});
        }
        a[j] = a[j] + a[k];
        a[k] = 0;
        --size;
      }
      else{
        for(int l = i + 1; l < t; l++){
          if(a[l] != 0){
            i = l;  break;
          }
        }
        for(int l = i + 1; l < t; l++){
          if(a[l] != 0){
            j = l;  break;
          }
        }
        for(int l = j + 1; l < t; l++){
          if(a[l] != 0){
            k = l;  break;
          }
        }
        continue;
      }
      for(int l = s; l < t; l++){
        if(a[l] != 0){
          i = l;  break;
        }
      }
      for(int l = i + 1; l < t; l++){
        if(a[l] != 0){
          j = l;  break;
        }
      }
      for(int l = j + 1; l < t; l++){
        if(a[l] != 0){
          k = l;  break;
        }
      }
    }

    if(size == 2){
      int jj = 0, kk = 0;
      for(int ii = s; ii < t; ii++){
        if(a[ii] != 0){
          jj = ii;  break;
        }
      }
      for(int ii = jj + 1; ii < t; ii++){
        if(a[ii] != 0){
          kk = ii;  break;
        }
      }
      if(a[jj] > a[kk]){
        list.add(new Integer[]{rank(s, t, jj) + m, 1});
        a[jj] = a[jj] + a[kk];
        a[kk] = 0;
      }
      else if(a[jj] < a[kk]){
        list.add(new Integer[]{rank(s, t, kk) + m, 0});
        a[kk] = a[kk] + a[jj];
        a[jj] = 0;
      }
      else{
        return null;
      }
    }

    return list.toArray(new Integer[list.size()][2]);
  }

  private static int rank(int s, int t, int i){
    int r = 0;
    for(int j = s; j <= i; j++){
      if(a[j] != 0){
        ++r;
      }
    }
    return r;
  }
}
