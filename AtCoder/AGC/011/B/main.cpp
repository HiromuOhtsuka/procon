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
  cin >> n;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  int b[n];
  for(int i = 0; i < n; i++){
    b[i] = a[i];
  }

  sort(b, b + n);

  ll sum[n + 1];
  sum[0] = 0;
  for(int i = 1; i <= n; i++){
    sum[i] = sum[i - 1] + b[i - 1];
  }

  int count = 0;
  for(int i = 0; i < n; i++){
    ll s = a[i];
    int k = 0;
    while(true){
      int j = distance(b, upper_bound(b + k, b + n, 2 * s));
      if(j <= k) break;
      s += sum[j] - sum[k];
      if(k == 0) s -= a[i];
      if(j == n){
        ++count;
        break;
      }
      k = j;
    }
  }

  cout << count << endl;

  return 0;
}
