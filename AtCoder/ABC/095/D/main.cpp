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

  int n;
  ll c;
  cin >> n >> c;
  ll x[n], v[n];
  for(int i = 0; i < n; i++) cin >> x[i] >> v[i];

  ll sum0[n + 1], sum1[n + 1];
  sum0[0] = sum1[0] = 0;
  for(int i = 1; i <= n; i++){
    sum0[i] = sum0[i - 1] + v[i - 1];
    sum1[i] = sum1[i - 1] + v[n - i];
  }

  ll ma0[n + 1], ma1[n + 1];
  ma0[0] = ma1[0] = 0;
  for(int i = 1; i <= n; i++){
    ma0[i] = max(ma0[i - 1], sum0[i] - x[i - 1]);
    ma1[i] = max(ma1[i - 1], sum1[i] - (c - x[n - i]));
  }

  ll ans = 0;
  for(int i = 1; i <= n; i++){
    ans = max(ans, sum0[i] - x[i - 1]);
    ans = max(ans, sum1[i] - (c - x[n - i]));
    ans = max(ans, sum0[i] - 2l * x[i - 1] + ma1[n - i]);
    ans = max(ans, sum1[i] - 2l * (c - x[n - i]) + ma0[n - i]);
  }

  cout << ans << endl;

  return 0;
}
