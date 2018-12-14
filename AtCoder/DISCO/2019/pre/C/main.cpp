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

ll pow(ll a, int b){
  ll r = 1;
  for(int i = 0; i < b; i++){
    r = (r * a) % MOD;
  }
  return r % MOD;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;

  init_comb();

  ll p[n + 1];
  p[1] = 1;
  for(int i = 2; i <= n; i++){
    p[i] = 0;
    for(int j = 1; j <= 10; j++){
      ll tmp = (comb(10, j) * 
          pow((ll)(i - 1), 10 - j)) % MOD;
      p[i] = (p[i] + tmp) % MOD;
    }
  }

  ll sum = 0;
  for(ll i = 1; i <= n; i++){
    for(ll j = 1; i * j <= n; j++){
      ll tmp = (p[i] * p[j]) % MOD;
      sum = (sum + tmp) % MOD;
    }
  }

  cout << sum << endl;

  return 0;
}
