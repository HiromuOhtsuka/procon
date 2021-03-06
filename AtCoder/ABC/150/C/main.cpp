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

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int p[n], q[n];
  for (int i = 0; i < n; i++) cin >> p[i];
  for (int i = 0; i < n; i++) cin >> q[i];

  int perm[n];
  for (int i = 0; i < n; i++) perm[i] = i + 1;

  int a = 0;
  do {
    bool ok = true;
    for (int i = 0; i < n; i++) {
      if (perm[i] != p[i]) ok = false;
    }
    if (ok) break;
    ++a;
  } while (next_permutation(perm, perm + n));

  for (int i = 0; i < n; i++) perm[i] = i + 1;
  int b = 0;
  do {
    bool ok = true;
    for (int i = 0; i < n; i++) {
      if (perm[i] != q[i]) ok = false;
    }
    if (ok) break;
    ++b;
  } while (next_permutation(perm, perm + n));

  int ans = abs(a - b);

  cout << ans << endl;

  return 0;
}
