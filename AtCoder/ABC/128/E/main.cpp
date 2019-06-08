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
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, q;
  cin >> n >> q;
  int s[n], t[n], x[n];
  for(int i = 0; i < n; i++){
    cin >> s[i] >> t[i] >> x[i];
  }
  int d[q];
  for(int i = 0; i < q; i++){
    cin >> d[i];
  }

  set< pii > ds;
  for(int i = 0; i < q; i++){
    ds.insert(make_pair(d[i], i));
  }

  vector< pii > v(n);
  for(int i = 0; i < n; i++){
    v[i] = make_pair(x[i], i);
  }
  sort(v.begin(), v.end());

  int ans[q];
  fill(ans, ans + q, -1);
  for(int i = 0; i < n; i++){
    int j = v[i].second;
    auto left = ds.lower_bound(make_pair(s[j] - x[j], 0));
    auto right = ds.upper_bound(make_pair(t[j] - 1 - x[j], q));
    vector< pii > toRemoved;
    for(auto it = left; it != right; it++){
      ans[(*it).second] = x[j];
      toRemoved.push_back(*it);
    }
    for(pii p: toRemoved) ds.erase(p);
  }

  string buf;
  for(int i = 0; i < q; i++){
    buf += to_string(ans[i]) + "\n";
  }

  cout << buf;

  return 0;
}
