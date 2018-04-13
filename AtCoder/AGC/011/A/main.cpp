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

  int n, c, k;
  cin >> n >> c >> k;
  int t[n];
  for(int i = 0; i < n; i++){
    cin >> t[i];
  }

  sort(t, t + n);
  int i = 0;
  int count = 0;
  while(i < n){
    int j = distance(t + i, upper_bound(t + i, t + n, t[i] + k));
    i += min(c, j);
    ++count;
  }

  cout << count << endl;

  return 0;
}
