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

  int n, d;
  cin >> n >> d;
  int x[n];
  for(int i = 0; i < n; i++) cin >> x[i];

  ll sum[n + 1];
  sum[n] = sum[n - 1] = 0;
  for(int i = n - 2; i >= 0; i--){
    sum[i] = sum[i + 1] + 
      distance(x + i, upper_bound(x + i, x + n, x[i] + d));
  }

  ll ans = 0;
  for(int i = 0; i < n; i++){
    int j = distance(x + i,
      upper_bound(x + i, x + n, x[i] + d));
    ll diff = (sum[i + 1] - sum[i + j]) - ((ll)j * (j - 1) / 2l);
    if(diff > 0) ans += diff;
  }

  cout << ans << endl;

  return 0;
}
