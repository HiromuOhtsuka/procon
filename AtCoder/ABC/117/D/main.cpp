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
typedef unsigned long long ull;
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

ull f(ull x, int n, ull a[]){
  ull sum = 0;
  for(int i = 0; i < n; i++){
    sum += x ^ a[i];
  }
  return sum;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  ull k;
  cin >> n >> k;
  ull a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  int d[64];
  fill(d, d + 64, 2);

  for(int i = 0; i < 64; i++){
    int c0 = 0, c1 = 0;
    for(int j = 0; j < n; j++){
      if(((1l << i) & a[j]) != 0) ++c0;
      else ++c1;
    }
    if(c0 > c1) d[i] = 0;
    else if(c0 < c1) d[i] = 1;
  }

  ull x = 0;
  for(int i = 63; i >= 0; i--){
    if(d[i] == 1){
      ull tmp = (1ll << i) | x;
      if(tmp <= k) x = tmp;
    }
  }

  ull ans = f(x, n, a);

  cout << ans << endl;

  return 0;
}
