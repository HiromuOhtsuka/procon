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
#include <cassert>
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

  int n, k;
  cin >> n >> k;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  int m = n * (n + 1) / 2;

  ll b[m];
  int sp = 0;
  for(int i = 0; i < n; i++){
    ll sum = 0;
    for(int j = i; j < n; j++){
      sum += (ll)a[j];
      b[sp++] = sum;
    }
  }

  ll ans = 0;
  for(int i = 50; i >= 0; i--){
    ll mask = 1l << i;
    int count = 0;
    for(int j = 0; j < m; j++){
      if((b[j] & (ans + mask)) == (ans + mask)) ++count;
    }
    if(count >= k) ans += mask;
  }

  cout << ans << endl;

  return 0;
}
