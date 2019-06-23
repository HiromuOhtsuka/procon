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
const long long MOD = 1000000007;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

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

  int n, m;
  cin >> n >> m;
  int s[n], t[m];
  for(int i = 0; i < n; i++) cin >> s[i];
  for(int i = 0; i < m; i++) cin >> t[i];

  ll dp[n + 1][m + 1][2][2];
  for(int i = 0; i <= n; i++){
    for(int j = 0; j <= m; j++){
      for(int k = 0; k < 2; k++){
        fill(dp[i][j][k], dp[i][j][k] + 2, 0);
      }
    }
  }

  for(int j = 0; j <= m; j++){
    dp[0][j][0][0] = 1;
  }
  for(int i = 0; i <= n; i++){
    dp[i][0][0][0] = 1;
  }

  for(int i = 1; i <= n; i++){
    for(int j = 1; j <= m; j++){
      for(int k = 0; k < 2; k++){
        for(int l = 0; l < 2; l++){
          if(k == 1 && l == 1){
            if(s[i - 1] == t[j - 1])
              dp[i][j][k][l] = (
                  (dp[i - 1][j - 1][0][0] +
                   dp[i - 1][j - 1][0][1]) % MOD +
                  (dp[i - 1][j - 1][1][0] +
                   dp[i - 1][j - 1][1][1]) % MOD
                  ) % MOD;
          }
          else if(k != 1 && l == 1){
            dp[i][j][k][l] = dp[i - 1][j][0][1];
            dp[i][j][k][l] = (dp[i][j][k][l] + dp[i - 1][j][1][1]) % MOD;
          }
          else if(k == 1 && l != 1){
            dp[i][j][k][l] = dp[i][j - 1][1][0];
            dp[i][j][k][l] = (dp[i][j][k][l] + dp[i][j - 1][1][1]) % MOD;
          }
          else{
            dp[i][j][k][l] = (
                (dp[i - 1][j - 1][0][0] +
                 dp[i - 1][j - 1][0][1]) % MOD +
                (dp[i - 1][j - 1][1][0] +
                 dp[i - 1][j - 1][1][1]) % MOD
                ) % MOD;
          }
        }
      }
    }
  }

  ll sum = dp[n][m][0][0];
  sum = (sum + dp[n][m][0][1]) % MOD;
  sum = (sum + dp[n][m][1][0]) % MOD;
  sum = (sum + dp[n][m][1][1]) % MOD;

  cout << sum << endl;

  return 0;
}
