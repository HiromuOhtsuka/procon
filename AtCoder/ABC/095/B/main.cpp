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

  int n, x;
  cin >> n >> x;
  int m[n];
  for(int i = 0; i < n; i++){
    cin >> m[i];
  }

  int mini = m[0];
  int sum = 0;
  for(int i = 0; i < n; i++){
    sum += m[i];
    mini = min(mini, m[i]);
  }

  int ans = n + (x - sum) / mini;

  cout << ans << endl;

  return 0;
}
