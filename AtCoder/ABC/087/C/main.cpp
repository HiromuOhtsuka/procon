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

  int n;
  cin >> n;
  int a[2][n];
  for(int i = 0; i < 2; i++){
    for(int j = 0; j < n; j++){
      cin >> a[i][j];
    }
  }

  int ans = 0;
  for(int i = 0; i < n; i++){
    int sum = 0;
    for(int j = 0; j <= i; j++){
      sum += a[0][j];
    }
    for(int j = i; j < n; j++){
      sum += a[1][j];
    }
    ans = max(ans, sum);
  }

  cout << ans << endl;

  return 0;
}
