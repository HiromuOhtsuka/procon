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

  int n, k, m;
  cin >> n >> k >> m;
  int a[n - 1];
  for (int i = 0; i < n - 1; i++) cin >> a[i];

  int sum = 0;
  for (int i = 0; i < n - 1; i++) {
    sum += a[i];
  }

  int ans = n * m - sum;
  if (ans > k) {
    cout << -1 << endl;
  } else {
    cout << max(0, ans) << endl;
  }

  return 0;
}
