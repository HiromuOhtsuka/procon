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

bool check(ll x, ll k, ll a[], ll f[], int n){
  ll sum = 0;
  for(int i = 0; i < n; i++){
    if(a[i] * f[n - i - 1] > x){
      sum += a[i] - (x / f[n - i - 1]);
    }
  }
  return sum <= k;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  ll k;
  cin >> n >> k;
  ll a[n], f[n];
  for(int i = 0; i < n; i++) cin >> a[i];
  for(int i = 0; i < n; i++) cin >> f[i];

  sort(a, a + n);
  sort(f, f + n);

  ll low = -1, high = INF_LONG;
  while(high - low > 1){
    ll mid = (high + low) / 2;
    if(check(mid, k, a, f, n)) high = mid;
    else low = mid;
  }

  cout << high << endl;

  return 0;
}
