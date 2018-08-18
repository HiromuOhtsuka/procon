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
#define MOD (1000000000 + 7)
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

  string t;
  cin >> t;

  int n = t.length();

  ll dp[4][n + 1];

  dp[0][0] = 1;
  for(int i = 1; i <= n; i++){
    if(t[i - 1] != '?') dp[0][i] = dp[0][i - 1];
    else dp[0][i] = (3l * dp[0][i - 1]) % MOD;
  }

  dp[1][0] = 0;
  for(int i = 1; i <= n; i++){
    dp[1][i] = dp[1][i - 1];
    if(t[i - 1] == '?' || t[i - 1] == 'A'){
      dp[1][i] = (dp[1][i] + dp[0][i - 1]) % MOD;
    }
    if(t[i - 1] == '?'){
      dp[1][i] = (dp[1][i] + dp[1][i - 1]) % MOD;
      dp[1][i] = (dp[1][i] + dp[1][i - 1]) % MOD;
    }
  }

  dp[2][0] = 0;
  for(int i = 1; i <= n; i++){
    dp[2][i] = dp[2][i - 1];
    if(t[i - 1] == '?' || t[i - 1] == 'B'){
      dp[2][i] = (dp[2][i] + dp[1][i - 1]) % MOD;
    }
    if(t[i - 1] == '?'){
      dp[2][i] = (dp[2][i] + dp[2][i - 1]) % MOD;
      dp[2][i] = (dp[2][i] + dp[2][i - 1]) % MOD;
    }
  }

  dp[3][0] = 0;
  for(int i = 1; i <= n; i++){
    dp[3][i] = dp[3][i - 1];
    if(t[i - 1] == '?' || t[i - 1] == 'C'){
      dp[3][i] = (dp[3][i] + dp[2][i - 1]) % MOD;
    }
    if(t[i - 1] == '?'){
      dp[3][i] = (dp[3][i] + dp[3][i - 1]) % MOD;
      dp[3][i] = (dp[3][i] + dp[3][i - 1]) % MOD;
    }
  }

  cout << dp[3][n] << endl;

  return 0;
}
