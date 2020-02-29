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

int digit(ll a, ll b) {
  ll count = 1;
  while (a / b != 0) {
    a /= b;
    ++count;
  }
  return count;
}

ll power(ll a, ll b) {
  ll result = 1;
  for (ll i = 0; i < b; i++) result *= a;
  return result;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  ll a, b, x;
  cin >> a >> b >> x;

  ll ans = 0;
  for (ll i = 1; i <= 10; i++) {
    ll tmp = (x - b * i) / a;
    if (digit(tmp, 10) > i) {
      ans = max(ans, min(power(10, i) - 1, 1000000000ll));
    } else if (digit(tmp, 10) == i) {
      ans = max(ans, min(tmp, 1000000000ll));
    }
  }

  cout << ans << endl;

  return 0;
}
