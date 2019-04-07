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

/*
ll fac[MAX], finv[MAX], inv[MAX];
void init_comb(){
  fac[0] = fac[1] = 1;
  finv[0] = finv[1] = 1;
  inv[1] = 1;
  for(int i = 2; i < MAX; i++){
    fac[i] = fac[i - 1] * i % MOD;
    inv[i] = MOD - inv[MOD % i] * (MOD / i) % MOD;
    finv[i] = finv[i - 1] * inv[i] % MOD;
  }
}

ll comb(int n, int k){
  if(n < k) return 0;
  if(n < 0 || k < 0) return 0;
  return fac[n] * (finv[k] * finv[n - k] % MOD) % MOD;
}
*/

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int x, y, z, k;
  cin >> x >> y >> z >> k;
  ll a[x], b[y], c[z];
  for(int i = 0; i < x; i++){
    cin >> a[i];
  }
  for(int i = 0; i < y; i++){
    cin >> b[i];
  }
  for(int i = 0; i < z; i++){
    cin >> c[i];
  }

  ll d[x * y];
  for(int i = 0; i < x; i++){
    for(int j = 0; j < y; j++){
      d[i * x + j] = a[i] + b[j];
    }
  }
  sort(d, d + x * y);

  vector< ll > e;
  for(int i = x * y - 1; i >= max(0, x * y - k); i--){
    for(int j = 0; j < z; j++){
      e.push_back(d[i] + c[j]);
    }
  }
  sort(e.begin(), e.end());

  string buf;
  for(int i = 0; i < k; i++){
    buf += to_string(e[e.size() - i - 1]) + "\n";
  }
  cout << buf;

  return 0;
}
