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
#define MOD (1000000007)
using namespace std;

typedef long long ll;
typedef pair< int, int > pii;

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
  int t[n], a[n];
  for(int i = 0; i < n; i++) cin >> t[i];
  for(int i = 0; i < n; i++) cin >> a[i];

  int mat = 0, maa = 0;
  for(int i = 0; i < n; i++){
    mat = max(mat, t[i]);
    maa = max(maa, a[i]);
  }
  if(mat != maa){
    cout << 0 << endl;
    return 0;
  }

  bool ng = false;
  int c[n];
  c[0] = 1;
  if(a[0] < t[0]) ng = true;
  for(int i = 1; i < n; i++){
    if(t[i - 1] < t[i]){
      if(a[i] < t[i]) ng = true;
      c[i] = 1;
    }
    else c[i] = t[i];
  }
  c[n - 1] = 1;
  if(a[n - 1] > t[n - 1]) ng = true;
  for(int i = n - 2; i >= 0; i--){
    if(a[i] > a[i + 1]){
      if(a[i] > t[i]) ng = true;
      c[i] = 1;
    }
    else c[i] = min(c[i], a[i]);
  }

  ll sum = 1;
  for(int i = 0; i < n; i++){
    sum = (sum * c[i]) % MOD;
  }

  if(!ng) cout << sum << endl;
  else cout << 0 << endl;

  return 0;
}
