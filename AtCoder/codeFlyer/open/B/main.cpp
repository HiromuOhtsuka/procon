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
  vector< ll > x(n);
  for(int i = 0; i < n; i++) cin >> x[i];
  vector< ll > c(q), d(q);
  for(int i = 0; i < q; i++) cin >> c[i] >> d[i];

  vector< ll > sum(n + 1);
  sum[0] = 0;
  for(int i = 1; i <= n; i++){
    sum[i] = sum[i - 1] + x[i - 1];
  }

  vector< ll > ans(q);
  for(int l = 0; l < q; l++){
    int i = distance(x.begin(), 
        upper_bound(x.begin(), x.end(), c[l] - d[l]));
    int j = distance(x.begin(), 
        upper_bound(x.begin(), x.end(), c[l]));
    int k = distance(x.begin(), 
        upper_bound(x.begin(), x.end(), c[l] + d[l]));
    ans[l] = (i + (n - k)) * d[l] + 
      (c[l] * (j - i) - (sum[j] - sum[i])) + 
      ((sum[k] - sum[j]) - (c[l] * (k - j)));
  }

  string buf;
  for(ll a: ans){
    buf += to_string(a) + "\n";
  }

  cout << buf;

  return 0;
}
