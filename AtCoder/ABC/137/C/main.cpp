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
  vector<string> s(n);
  for (int i = 0; i < n; i++) {
    cin >> s[i];
  }

  map<string, int> count;
  for (int i = 0; i < n; i++) {
    vector<char> tmp;
    for (char c : s[i]) tmp.push_back(c);
    sort(tmp.begin(), tmp.end());
    string t;
    for (char c : tmp) t.push_back(c);
    count[t] += 1;
  }

  ll sum = 0;
  for (pair<string, int> p : count) {
    ll size = p.second;
    sum += size * (size - 1) / 2;
  }

  cout << sum << endl;

  return 0;
}
