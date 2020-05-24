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

int h, w;
int n;
vector<int> graph[400];

int ceil(int x, int y) { return (x % y == 0) ? x / y : x / y + 1; }

int gcd(int x, int y) { return y ? gcd(y, x % y) : x; }

int lcm(int x, int y) { return x / gcd(x, y) * y; }

void bfs(int s, int dist[]) {
  fill(dist, dist + n, INF_INT);
  dist[s] = 0;
  queue<int> que;
  que.push(s);
  while (!que.empty()) {
    int v = que.front();
    que.pop();
    for (int t : graph[v]) {
      if (dist[t] > dist[v] + 1) {
        dist[t] = dist[v] + 1;
        que.push(t);
      }
    }
  }
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> h >> w;
  n = h * w;
  string s[20];
  for (int i = 0; i < h; i++) cin >> s[i];

  int dw[] = {1, 0, -1, 0};
  int dh[] = {0, 1, 0, -1};
  int v = 0;
  for (int i = 0; i < h; i++) {
    for (int j = 0; j < w; j++) {
      if (s[i][j] == '.') {
        for (int k = 0; k < 4; k++) {
          int i2 = i + dh[k];
          int j2 = j + dw[k];
          if (i2 < 0 || i2 >= h) continue;
          if (j2 < 0 || j2 >= w) continue;
          int t = i2 * w + j2;
          if (s[i2][j2] == '.') {
            graph[v].push_back(t);
          }
        }
      }
      ++v;
    }
  }

  int ans = 0;
  for (int i = 0; i < n; i++) {
    int dist[n];
    bfs(i, dist);
    for (int j = 0; j < n; j++) {
      if (dist[j] != INF_INT) ans = max(ans, dist[j]);
    }
  }

  cout << ans << endl;

  return 0;
}
