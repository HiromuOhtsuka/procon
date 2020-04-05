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

int gcd(int x, int y) { return y ? gcd(y, x % y) : x; }

int lcm(int x, int y) { return x / gcd(x, y) * y; }

int n;
ll m;
ll a[MAX];

bool f(ll x) {
  ll count = 0;
  for (int i = 0; i < n; i++) {
    count += n - distance(a, lower_bound(a, a + n, x - a[i]));
  }
  return count < m;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> a[i];

  sort(a, a + n);

  ll sum[n + 1];
  sum[0] = 0;
  for (int i = 1; i <= n; i++) {
    sum[i] = sum[i - 1] + a[i - 1];
  }

  ll low = 0, high = INF_LONG;
  while (high - low > 1) {
    ll mid = (low + high) / 2;
    if (f(mid))
      high = mid;
    else
      low = mid;
  }

  ll ans = 0;
  for (int i = 0; i < n; i++) {
    int j = distance(a, lower_bound(a, a + n, high - a[i]));
    ans += (sum[n] - sum[j]) + a[i] * (n - j);
    m -= (n - j);
  }
  ans += m * low;

  cout << ans << endl;

  return 0;
}
