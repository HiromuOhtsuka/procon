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

const int MAX = 100000;
const int MOD = 1000000007;

typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef pair<ll, int> pli;
typedef pair<int, ll> pil;

int ceil(int x, int y) { return (x % y == 0) ? x / y : x / y + 1; }

int gcd(int x, int y) { return y ? gcd(y, x % y) : x; }

int lcm(int x, int y) { return x / gcd(x, y) * y; }

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  set<ll> p;
  ll i = 2;
  bool cond = true;
  while (cond) {
    bool prime = true;
    for (ll j = 2; j * j <= i; j++) {
      if (i % j == 0) {
        prime = false;
        break;
      }
    }
    if (prime) {
      p.insert(i);
      if (i >= MAX) {
        cond = false;
      }
    }
    ++i;
  }

  int x;
  cin >> x;

  int ans = *p.lower_bound(x);
  cout << ans << endl;

  return 0;
}
