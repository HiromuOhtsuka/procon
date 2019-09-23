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
  int a[n], b[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }

  vector<pii> c;
  for (int i = 0; i < n; i++) {
    c.push_back(make_pair(a[i], b[i]));
  }
  sort(c.begin(), c.end());

  priority_queue<int> pq;
  int j = 0;
  int sum = 0;
  for (int i = n; i > 0; i--) {
    while (j < n && c[j].first + i <= m + 1) {
      pq.push(c[j].second);
      ++j;
    }
    if (!pq.empty()) {
      sum += pq.top();
      pq.pop();
    }
  }

  cout << sum << endl;

  return 0;
}
