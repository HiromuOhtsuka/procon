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

const int MAX = 100001;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

const ll MOD = 998244353;

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

ll dp[301][300 * 300 + 1];
ll dp2[301][300 * 300 + 1];

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  ll a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  for(int i = 0; i <= n; i++){
    fill(dp[i], dp[i] + n * 300 + 1, 0);
    fill(dp2[i], dp2[i] + n * 300 + 1, 0);
  }

  dp[0][0] = 1;
  for(int i = 1; i <= n; i++){
    for(int j = 0; j <= n * 300; j++){
      if(j - a[i - 1] >= 0){
        dp[i][j] = (dp[i][j] + dp[i - 1][j - a[i - 1]]) % MOD;
      }
      ll tmp = (dp[i - 1][j] * 2) % MOD;
      dp[i][j] = (dp[i][j] + tmp) % MOD;
    }
  }

  dp2[0][0] = 1;
  for(int i = 1; i <= n; i++){
    for(int j = 0; j <= n * 300; j++){
      if(j - a[i - 1] >= 0){
        dp2[i][j] = (dp2[i][j] + dp2[i - 1][j - a[i - 1]]) % MOD;
      }
      dp2[i][j] = (dp2[i][j] + dp2[i - 1][j]) % MOD;
    }
  }

  ll sum = 0;
  for(int i = 0; i < n; i++){
    sum += a[i];
  }

  ll ans = 1;
  for(int i = 0; i < n; i++){
    ans = (((ans + ans) % MOD) + ans) % MOD;
  }

  for(int i = ceil(sum, 2); i <= sum; i++){
    ll tmp = (((dp[n][i] + dp[n][i]) % MOD) + dp[n][i]) % MOD;
    ans = (ans - tmp + MOD) % MOD;
  }


  if(sum % 2 == 0){
    ll tmp = (((dp2[n][sum / 2] + dp2[n][sum / 2]) % MOD) + dp2[n][sum / 2]) % MOD;
    ans = (ans + tmp) % MOD;
  }

  cout << ans << endl;

  return 0;
}
