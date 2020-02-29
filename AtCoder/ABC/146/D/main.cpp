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

#define MAX_N 100000

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

struct edge {
  int v, w, i;
};

vector<edge> graph[MAX_N];

void color(int v, int p, int pc, int ans[]) {
  int c = 1;
  for (edge e : graph[v]) {
    int w = e.w;
    if (w == p) continue;
    if (c != pc) {
      ans[e.i] = c;
    } else {
      ++c;
      ans[e.i] = c;
    }
    color(w, v, c, ans);
    ++c;
  }
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n - 1], b[n - 1];
  for (int i = 0; i < n - 1; i++) {
    cin >> a[i] >> b[i];
    --a[i];
    --b[i];
  }

  for (int i = 0; i < n - 1; i++) {
    graph[a[i]].push_back(edge{a[i], b[i], i});
    graph[b[i]].push_back(edge{b[i], a[i], i});
  }

  int k = 1;
  for (int v = 0; v < n; v++) {
    k = max(k, (int)graph[v].size());
  }

  int ans[n - 1];
  color(0, -1, 0, ans);

  string buf;
  buf += to_string(k) + "\n";
  for (int i = 0; i < n - 1; i++) {
    buf += to_string(ans[i]) + "\n";
  }

  cout << buf;

  return 0;
}
