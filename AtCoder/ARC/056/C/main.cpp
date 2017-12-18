#include <iostream>
#include <algorithm>
#define MAX_N 17
using namespace std;

int main(){
  int n;
  long long k;
  cin >> n >> k;
  int w[n][n];
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      cin >> w[i][j];
    }
  }

  int sum[1 << n];
  fill(sum, sum + (1 << n), 0);
  for(int s = 1; s < (1 << n); s++){
    for(int u = 0; u < n; u++){
      for(int v = u + 1; v < n; v++){
        if((s & (1 << u)) != 0 && (s & (1 << v)) != 0){
          sum[s] += w[u][v];
        }
      }
    }
  }

  long long dp[1 << n];
  fill(dp, dp + (1 << n), 0);
  dp[0] = 0;
  for(int sup = 1; sup < (1 << n); sup++){
    int sub = sup;
    do{
      int t = sup & ~sub;
      dp[sup] = max(dp[sup], dp[t] + k
          - (sum[sup] - (sum[sub] + sum[t])));
      sub = (sub - 1) & sup;
    }while(sub != 0);
  }

  cout << dp[(1 << n) - 1] << endl;

  return 0;
}
