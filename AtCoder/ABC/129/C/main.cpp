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

ll l_pow(ll a, ll b){
  ll result = 1;
  ll base = a;
  for(int i = 0; i < 64; i++){
    if((b & (1l << i)) != 0){
      result = (result * base) % MOD;
    }
    base = (base * base) % MOD;
  }
  return result;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  int a[m];
  for(int i = 0; i < m; i++) cin >> a[i];

  set< int > s;
  for(int i = 0; i < m; i++){
    s.insert(a[i]);
  }

  ll dp[n + 1];
  dp[0] = dp[1] = 1;
  for(int i = 2; i <= n; i++){
    ll d1 = (s.find(i - 1) != s.end() ? 0 : dp[i - 1]);
    ll d2 = (s.find(i - 2) != s.end() ? 0 : dp[i - 2]);
    dp[i] = (d1 + d2) % MOD;
  }

  cout << dp[n] << endl;

  return 0;
}
