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

int bit_count(int n) {
  int count = 0;
  for (int i = 0; i < 32; i++) {
    if ((n & (1 << i)) != 0) ++count;
  }
  return count;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n], x[n][n], y[n][n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    for (int j = 0; j < a[i]; j++) {
      cin >> x[i][j] >> y[i][j];
      --x[i][j];
    }
  }

  int ans = 0;
  for (int i = 0; i < (1 << n); i++) {
    bool ok = true;
    for (int j = 0; j < n && ok; j++) {
      if ((i & (1 << j)) != 0) {
        for (int k = 0; k < a[j]; k++) {
          bool c1 = (i & (1 << x[j][k])) != 0;
          bool c2 = (y[j][k] == 1);
          if (c1 != c2) {
            ok = false;
            break;
          }
        }
      }
    }
    if (ok) ans = max(ans, bit_count(i));
  }

  cout << ans << endl;

  return 0;
}
