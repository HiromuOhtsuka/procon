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

bool unique(int a[], int n){
  for(int i = 0; i < n; i++){
    for(int j = i + 1; j < n; j++){
      if(a[i] == a[j]) return false;
    }
  }
  return true;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  int a[n], b[m];
  for(int i = 0; i < n; i++) cin >> a[i];
  for(int i = 0; i < m; i++) cin >> b[i];

  if(!(unique(a, n) && unique(b, m))){
    cout << 0 << endl;
    return 0;
  }

  ll p[n * m + 1];
  fill(p, p + n * m + 1, -1);

  for(int i = 0; i < n; i++){
    bool c = false;
    int count = 0;
    for(int j = 0; j < m; j++){
      if(a[i] == b[j]){
        c = true;
        p[a[i]] = 1;
        break;
      }
      if(b[j] >= a[i]) ++count;
    }
    if(!c) p[a[i]] = count;
  }

  for(int j = 0; j < m; j++){
    bool c = false;
    int count = 0;
    for(int i = 0; i < n; i++){
      if(a[i] == b[j]){
        c = true;
        p[b[j]] = 1;
        break;
      }
      if(a[i] >= b[j]) ++count;
    }
    if(!c) p[b[j]] = count;
  }

  sort(a, a + n);
  sort(b, b + m);

  ll sum = 1;
  ll count = 0;
  for(int i = n * m; i >= 1; i--){
    if(p[i] >= 0) sum = (sum * p[i]) % MOD;
    else{
      ll tmp = n - distance(a, upper_bound(a, a + n, i));
      tmp = (tmp * (m - distance(b, upper_bound(b, b + m, i))));
      if(tmp - count <= 0){
        sum = 0;
        break;
      }
      sum = (sum * (tmp - count)) % MOD;
    }
    ++count;
  }

  cout << sum << endl;

  return 0;
}
