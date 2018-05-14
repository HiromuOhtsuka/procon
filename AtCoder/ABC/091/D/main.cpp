#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
#define DEBUG true
//#define DEBUG false
using namespace std;

typedef long long ll;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  ll a[n], b[n];
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }
  for(int i = 0; i < n; i++){
    cin >> b[i];
  }

  ll ans = 0;
  ll c[n];
  for(int i = 0; i < 30; i++){
    for(int j = 0; j < n; j++){
      c[j] = b[j] % (1ll << (i + 1));
    }
    sort(c, c + n);
    ll count = 0;
    for(int j = 0; j < n; j++){
      ll aj = a[j] % (1ll << (i + 1));
      count += distance(
          lower_bound(c, c + n, (1ll << i) - aj),
          lower_bound(c, c + n, 2 * (1ll << i) - aj));
      count += distance(
          lower_bound(c, c + n, 3 * (1ll << i) - aj),
          lower_bound(c, c + n, 4 * (1ll << i) - aj));
    }
    if(count % 2 == 1) ans |= 1ll << i;
  }

  cout << ans << endl;

  return 0;
}
