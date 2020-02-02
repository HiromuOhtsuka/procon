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
  int x[n], y[n];
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> y[i];
  }

  vector<int> p(n);
  for (int i = 0; i < n; i++) {
    p[i] = i;
  }

  double sum = 0;
  int count = 0;
  do {
    for (int i = 0; i + 1 < n; i++) {
      double dx = x[p[i + 1]] - x[p[i]];
      double dy = y[p[i + 1]] - y[p[i]];
      sum += sqrt(dx * dx + dy * dy);
    }
    ++count;
  } while (next_permutation(p.begin(), p.end()));

  double ans = sum / count;

  printf("%.7lf\n", ans);

  return 0;
}
