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
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef pair<ll, int> pli;
typedef pair<int, ll> pil;

int ceil(int x, int y) { return (x % y == 0) ? x / y : x / y + 1; }

int gcd(int x, int y) { return y ? gcd(y, x % y) : x; }

int lcm(int x, int y) { return x / gcd(x, y) * y; }

ll mod(ll n) { return n % MOD; }

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  ll a[n];
  for (int i = 0; i < n; i++) cin >> a[i];

  ll sum = 0;
  for (int i = 0; i < 61; i++) {
    ll c1 = 0;
    for (int j = 0; j < n; j++) {
      if ((a[j] & (1ll << i)) != 0) ++c1;
    }
    ll c0 = (n - c1);
    sum = mod(sum + mod(mod(1ll << i) * mod(c0 * c1)));
  }

  cout << sum << endl;

  return 0;
}
