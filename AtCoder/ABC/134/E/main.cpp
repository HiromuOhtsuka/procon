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
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  vector< int > b(n);
  for(int i = 0; i < n; i++){
    b[n - i - 1] = a[i];
  }

  int dp[n];
  fill(dp, dp + n, INF_INT);
  dp[0] = b[0];
  for(int i = 1; i < n; i++){
    auto lb = upper_bound(dp, dp + n, b[i]);
    *lb = b[i];
  }

  int ans = 1;
  for(int i = 0; i < n; i++){
    if(dp[i] != INF_INT) ans = i + 1;
  }

  cout << ans << endl;

  return 0;
}
