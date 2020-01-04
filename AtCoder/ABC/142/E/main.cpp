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

  int n, m;
  cin >> n >> m;
  int a[m], b[m], c[m][n];
  for(int i = 0; i < m; i++){
    cin >> a[i] >> b[i];
    for(int j = 0; j < b[i]; j++){
      cin >> c[i][j];
    }
  }

  int d[m];
  for(int i = 0; i < m; i++){
    d[i] = 0;
    for(int j = 0; j < b[i]; j++){
      d[i] |= 1 << (c[i][j] - 1);
    }
  }

  int dp[m + 1][1 << n];

  for(int i = 0; i < m + 1; i++){
    fill(dp[i], dp[i] + (1 << n), INF_INT);
  }

  dp[0][0] = 0;

  for(int i = 0; i + 1 <= m; i++){
    for(int j = 0; j < (1 << n); j++){
      dp[i + 1][j] = dp[i][j];
    }
    for(int j = 0; j < (1 << n); j++){
      dp[i + 1][j | d[i]] = min(dp[i][j] + a[i], dp[i + 1][j | d[i]]);
    }
  }

  int ans = dp[m][(1 << n) - 1];
  if(ans == INF_INT) ans = -1;

  cout << ans << endl;

  return 0;
}
