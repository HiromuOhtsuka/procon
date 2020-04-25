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

const int MAX = 100001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef pair<ll, int> pli;
typedef pair<int, ll> pil;

int ceil(int x, int y) { return (x % y == 0) ? x / y : x / y + 1; }

ll gcd(ll x, ll y) { return y ? gcd(y, x % y) : x; }

ll lcm(ll x, ll y) { return x / gcd(x, y) * y; }

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  ll m;
  cin >> n >> m;
  ll a[n];
  for (int i = 0; i < n; i++) cin >> a[i];

  int count = 0;
  ll tmp = a[0] / 2;
  while (tmp % 2 == 0) {
    tmp /= 2;
    ++count;
  }

  bool check = true;
  for (int i = 1; i < n; i++) {
    int c = 0;
    tmp = a[i] / 2;
    while (tmp % 2 == 0) {
      tmp /= 2;
      ++c;
    }
    if (c != count) {
      check = false;
      break;
    }
  }

  if (!check) {
    cout << 0 << endl;
    return 0;
  }

  ll l = a[0] / 2;
  for (int i = 1; i < n; i++) {
    l = lcm(l, a[i] / 2);
    if (l > m) break;
  }

  ll ans = (m + l) / (2 * l);

  if (l <= m)
    cout << ans << endl;
  else
    cout << 0 << endl;

  return 0;
}
