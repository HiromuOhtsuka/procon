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
//#define DEBUG true
#define DEBUG false
using namespace std;

typedef long long ll;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  ll x[n], y[n], z[n];
  for(int i = 0; i < n; i++){
    cin >> x[i] >> y[i] >> z[i];
  }

  int dx[2] = {-1, 1};
  int dy[2] = {-1, 1};
  int dz[2] = {-1, 1};
  ll ans = 0;
  for(int i = 0; i < 2; i++){
    for(int j = 0; j < 2; j++){
      for(int k = 0; k < 2; k++){
        ll a[n];
        for(int l = 0; l < n; l++){
          a[l] = dx[i] * x[l] + dy[j] * y[l] + dz[k] * z[l];
        }
        sort(a, a + n);
        ll sum = 0;
        for(int l = n - 1; l >= n - m; l--){
          sum += a[l];
        }
        ans = max(ans, sum);
      }
    }
  }

  cout << ans << endl;

  return 0;
}
