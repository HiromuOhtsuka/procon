#include <iostream>
#include <algorithm>
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  int g[n];
  fill(g, g + n, 0);
  for(int i = 0; i < n; i++){
    int p;
    cin >> p;
    for(int j = 0; j < p; j++){
      int k;
      cin >> k;
      g[i] |= (1 << (k - 1));
    }
  }

  int dp[2][1 << m];
  fill(dp[0], dp[0] + (1 << m), 0);
  fill(dp[1], dp[1] + (1 << m), 0);
  dp[0][0] = 1;
  for(int i = 0; i < n; i++){
    for(int s = 0; s < (1 << m); s++){
      int sum = 0;
      for(int j = s; j != 0; j &= ~(j & (-j))){
        int k = j & -j;
        if(((s & k) != 0) && ((g[i] & k) != 0)){
          sum += dp[i % 2][s & ~k];
        }
      }
      dp[(i + 1) % 2][s] = sum;
    }
  }

  int sum = 0;
  for(int s = 0; s < (1 << m); s++){
    sum += dp[n % 2][s];
  }

  cout << sum << endl;

  return 0;
}
