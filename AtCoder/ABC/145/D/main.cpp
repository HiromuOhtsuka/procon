#include <algorithm>
#include <climits>
#include <cmath>
#include <deque>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <string>
#include <vector>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

const int MAX = 1000001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef pair<ll, int> pli;
typedef pair<int, ll> pil;

int ceil(int x, int y) { return (x % y == 0) ? x / y : x / y + 1; }

int gcd(int x, int y) { return y ? gcd(y, x % y) : x; }

int lcm(int x, int y) { return x / gcd(x, y) * y; }

ll fac[MAX], finv[MAX], inv[MAX];
void init_comb() {
  fac[0] = fac[1] = 1;
  finv[0] = finv[1] = 1;
  inv[1] = 1;
  for (int i = 2; i < MAX; i++) {
    fac[i] = fac[i - 1] * i % MOD;
    inv[i] = MOD - inv[MOD % i] * (MOD / i) % MOD;
    finv[i] = finv[i - 1] * inv[i] % MOD;
  }
}

ll comb(int n, int k) {
  if (n < k) return 0;
  if (n < 0 || k < 0) return 0;
  return fac[n] * (finv[k] * finv[n - k] % MOD) % MOD;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int x, y;
  cin >> x >> y;

  if ((x + y) % 3 != 0 || (2 * x - y) % 3 != 0) {
    cout << "0" << endl;
    return 0;
  }

  int c = (2 * x - y) / 3;

  if (c < 0 || x - 2 * c < 0) {
    cout << "0" << endl;
    return 0;
  }

  init_comb();

  ll ans = (((fac[x - c] * finv[x - (2 * c)]) % MOD) * finv[c]) % MOD;

  cout << ans << endl;

  return 0;
}
