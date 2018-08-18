#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#include <deque>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

typedef long long ll;
typedef pair< int, int > pii;

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int d, g;
  cin >> d >> g;
  int p[d], c[d];
  for(int i = 0; i < d; i++) cin >> p[i] >> c[i];

  g /= 100;
  for(int i = 0; i < d; i++){
    c[i] /= 100;
  }

  int dp[d + 1][200001];
  for(int i = 0; i <= d; i++){
    fill(dp[i], dp[i] + 200001, INF_INT);
  }

  dp[0][0] = 0;
  for(int i = 1; i <= d; i++){
    for(int j = 0; j <= 200000; j++){
      for(int k = 0; k < p[i - 1]; k++){
        if(j - (i * k) >= 0)
          dp[i][j] = min(dp[i][j],
              dp[i - 1][j - (i * k)] + k);
      }
      if(j - (i * p[i - 1] + c[i - 1]) >= 0)
        dp[i][j] = min(dp[i][j],
            dp[i - 1][j - (i * p[i - 1] + c[i - 1])] + p[i - 1]);
    }
  }

  int ans = INF_INT;
  for(int i = g; i <= 200000; i++){
    ans = min(ans, dp[d][i]);
  }

  cout << ans << endl;

  return 0;
}
