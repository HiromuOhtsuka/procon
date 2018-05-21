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
  int a[n + 2];
  a[0] = a[n + 1] = 0;
  for(int i = 0; i < n; i++){
    cin >> a[i + 1];
  }

  int sum = 0;
  for(int i = 0; i + 1 < n + 2; i++){
    sum += abs(a[i] - a[i + 1]);
  }

  string ans;
  for(int i = 1; i <= n; i++){
    int tmp = sum - 
      (abs(a[i] - a[i - 1]) + abs(a[i] - a[i + 1])) +
      abs(a[i - 1] - a[i + 1]);
    ans += to_string(tmp) + "\n";
  }

  cout << ans;

  return 0;
}
