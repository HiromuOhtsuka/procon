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

  int n, m;
  cin >> n >> m;
  int p[m];
  string s[MAX];
  for (int i = 0; i < m; i++) {
    cin >> p[i];
    cin >> s[i];
  }

  int c[n];
  bool b[n];

  fill(c, c + n, 0);
  fill(b, b + n, false);

  for (int i = 0; i < m; i++) {
    int j = p[i] - 1;
    if (!b[j]) {
      if (s[i] == "WA") {
        ++c[j];
      } else {
        b[j] = true;
      }
    }
  }

  int sum = 0, ac = 0;
  for (int i = 0; i < n; i++) {
    if (b[i]) {
      sum += c[i];
      ++ac;
    }
  }

  cout << ac << " " << sum << endl;

  return 0;
}
