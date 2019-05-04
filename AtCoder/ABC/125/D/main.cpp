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

  int n;
  cin >> n;
  ll a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  ll dp[n + 1][2];
  dp[0][0] = dp[0][1] = 0;
  dp[1][0] = a[0];  dp[1][1] = -INF_LONG;
  for(int i = 2; i <= n; i++){
    dp[i][0] = max(dp[i - 1][0] + a[i - 1],
        dp[i - 1][1] + a[i - 1]);
    dp[i][1] = max(dp[i - 1][0] + -2 * a[i - 2] + -a[i - 1],
        dp[i - 1][1] + 2 * a[i - 2] + -a[i - 1]);
  }

  ll ans = max(dp[n][0], dp[n][1]);

  cout << ans << endl;

  return 0;
}
