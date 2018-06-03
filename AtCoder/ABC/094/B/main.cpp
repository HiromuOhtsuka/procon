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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m, x;
  cin >> n >> m >> x;
  int a[m];
  for(int i = 0; i < m; i++){
    cin >> a[i];
  }

  int b[n + 1];
  fill(b, b + n + 1, 0);
  for(int i = 0; i < m; i++){
    b[a[i]] = 1;
  }

  int s = x;
  int cost0 = 0;
  while(s <= n){
    cost0 += b[s];
    s++;
  }
  s = x;
  int cost1 = 0;
  while(s >= 0){
    cost1 += b[s];
    --s;
  }

  int ans = min(cost0, cost1);

  cout << ans << endl;

  return 0;
}
