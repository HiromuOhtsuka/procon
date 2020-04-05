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

char wise2(char a, char b) {
  if (a != 'r' && b != 'r') return 'r';
  if (a != 's' && b != 's') return 's';
  return 'p';
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, k;
  int r, s, p;
  string t;
  cin >> n >> k;
  cin >> r >> s >> p;
  cin >> t;

  map<char, char> win;
  win['r'] = 'p';
  win['s'] = 'r';
  win['p'] = 's';

  map<char, char> lose;
  lose['r'] = 's';
  lose['s'] = 'p';
  lose['p'] = 'r';

  map<char, int> point;
  point['r'] = r;
  point['s'] = s;
  point['p'] = p;

  int sum = 0;
  string ss;
  for (int i = 0; i < n; i++) {
    if (i - k < 0 || ss[i - k] != win[t[i]]) {
      sum += point[win[t[i]]];
      ss.push_back(win[t[i]]);
    } else {
      if (i + k < n) {
        if (t[i + k] != ss[i - k])
          ss.push_back(t[i + k]);
        else if (lose[t[i + k]] != ss[i - k])
          ss.push_back(lose[t[i + k]]);
        else
          ss.push_back(wise2(t[i + k], lose[t[i + k]]));
      } else {
        ss.push_back(win[ss[i - k]]);
      }
    }
  }

  cout << sum << endl;

  return 0;
}
