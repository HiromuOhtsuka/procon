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
const int MOD = 1000000007;

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

  int n, k;
  cin >> n >> k;
  ll a[n];
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }

  int sum = 0;
  int b[n];
  for(int i = 0; i < n; i++){
    ll tmp = a[i];
    b[i] = 0;
    while(tmp != 0){
      tmp /= 2;
      ++b[i];
    }
    sum += b[i];
  }

  ll dp[n + 1][2][sum + 1];
  for(int j = 0; j < 2; j++){
    fill(dp[0][j], dp[0][j] + sum + 1, 0);
  }
  dp[0][0][0] = 1;

  for(int i = 1; i <= n; i++){
    for(int j = 0; j < 2; j++){
      for(int k = 0; k <= sum; k++){
        dp[i][j][k] = 0;
        if(j == 0){
          for(int l = 0; k - l >= 0 && l < b[i - 1]; l++){
            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - l]) % MOD;
          }
        }
        else{
          for(int l = 0; k - l >= 0 && l < b[i - 1]; l++){
            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - l]) % MOD;
          }
          if(k - b[i - 1] >= 0){
            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][0][k - b[i - 1]]) % MOD;
            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][1][k - b[i - 1]]) % MOD;
          }
        }
      }
    }
  }

  ll ans = 0;
  if(k > sum){
    for(int i = 0; i <= sum; i++){
      ans = (ans + dp[n][1][i]) % MOD;
    }
  }
  else{
    for(int i = 0; i <= k; i++){
      ans = (ans + dp[n][1][i]) % MOD;
    }
    ans = (ans + dp[n][0][k]) % MOD;
  }

  cout << ans << endl;

  return 0;
}
