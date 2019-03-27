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
#define DEBUG true
//#define DEBUG false
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

  int n, m;
  ll k;
  cin >> n >> m >> k;
  ll a[n], b[m];
  for(int i = 0; i < n; i++) cin >> a[i];
  for(int i = 0; i < m; i++) cin >> b[i];

  if(n == m){
    bool same = true;
    for(int i = 0; i < n; i++){
      if(a[i] != b[i]){
        same = false;
        break;
      }
    }
    if(same){
      cout << "Same" << endl;
      return 0;
    }
  }

  ll base[32];
  base[0] = 1;
  int c = 0;
  for(int i = 1; base[i - 1] <= 1e9; i++){
    base[i] = base[i - 1] * k;
    ++c;
  }

  int x[2 * MAX], y[2 * MAX];
  fill(x, x + 2 * MAX, 0);
  fill(y, y + 2 * MAX, 0);

  for(int i = 0; i < n; i++){
    for(int j = c - 1; j >= 0; j--){
      if(a[i] >= base[j]){
        x[j + n - i - 1] += a[i] / base[j];
        a[i] -= base[j] * (a[i] / base[j]);
      }
    }
  }

  for(int i = 0; i < m; i++){
    for(int j = c - 1; j >= 0; j--){
      if(b[i] >= base[j]){
        y[j + m - i - 1] += b[i] / base[j];
        b[i] -= base[j] * (b[i] / base[j]);
      }
    }
  }

  bool f = false;
  for(int i = 2 * MAX - 1; i >= 0; i--){
    if(x[i] < y[i]){
      f = true;
      break;
    }
    else if(x[i] > y[i]) break;
  }

  if(f) cout << "X" << endl;
  else cout << "Y" << endl;

  return 0;
}
