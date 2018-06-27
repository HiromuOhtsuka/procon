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

  int n, k;
  cin >> n >> k;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  ll sum[n + 1], sp[n + 1];
  sum[0] = sp[0] = 0;
  for(int i = 1; i <= n; i++){
    sum[i] = sum[i - 1] + a[i - 1];
    if(a[i - 1] > 0){
      sp[i] = sp[i - 1] + a[i - 1];
    }
    else{
      sp[i] = sp[i - 1];
    }
  }

  ll ans = 0;
  for(int i = 0; i + k <= n; i++){
    ll tmp = sp[i] + (sp[n] - sp[i + k]);
    ans = max(ans, tmp);
    tmp += sum[i + k] - sum[i];
    ans = max(ans, tmp);
  }

  cout << ans << endl;

  return 0;
}
