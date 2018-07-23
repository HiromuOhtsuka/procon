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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  ll sum[n + 1];
  sum[0] = 0;
  for(int i = 1; i <= n; i++){
    sum[i] = sum[i - 1] + a[i - 1];
  }

  int i = 2;
  int j = 1;
  int k = j + 1;
  ll ans = INF_INT;
  while(i < n - 1){
    ll left = sum[i];
    ll right = sum[n] - sum[i];
    while(j + 1< i &&
        abs(sum[j] - (left - sum[j])) > abs(sum[j + 1] - (left - sum[j + 1]))){
      ++j;
    }
    while(k + 1 < n &&
        abs(sum[k] - sum[i] - (right - (sum[k] - sum[i]))) > 
        abs(sum[k + 1] - sum[i] - (right - (sum[k + 1] - sum[i])))){
      ++k;
    }
    ll p = sum[j];
    ll q = sum[i] - sum[j];
    ll r = sum[k] - sum[i];
    ll s = sum[n] - sum[k];
    ll mx = max(max(p, q), max(r, s));
    ll mi = min(min(p, q), min(r, s));
    ans = min(ans, mx - mi);
    ++i;
  }

  cout << ans << endl;

  return 0;
}
