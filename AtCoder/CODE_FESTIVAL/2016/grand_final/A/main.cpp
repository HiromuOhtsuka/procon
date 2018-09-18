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
#define MOD (1000000007)
#define DEBUG false
using namespace std;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;
typedef pair< int, bool > pib;

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

  int n;
  cin >> n;
  int a[n], b[n];
  for(int i = 0; i < n; i++) cin >> a[i];
  for(int i = 0; i < n; i++) cin >> b[i];

  vector< pib > c(2 * n);
  for(int i = 0; i < n; i++){
    c[i] = make_pair(a[i], true);
  }
  for(int i = 0; i < n; i++){
    c[i + n] = make_pair(b[i], false);
  }
  sort(c.begin(), c.end());

  ll sum = 1;
  int j = 0, k = 0;
  for(int i = 0; i < 2 * n; i++){
    if(c[i].second){
      ++j;
      if(k > 0){
        sum = (sum * k) % MOD;
        --k; --j;
      }
    }
    else{
      ++k;
      if(j > 0){
        sum = (sum * j) % MOD;
        --j; --k;
      }
    }
  }

  cout << sum << endl;

  return 0;
}
