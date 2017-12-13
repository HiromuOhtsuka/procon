#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int x, y, z;
  cin >> x >> y >> z;

  int ans = (x - z) / (y + z);
  cout << ans << endl;

  return 0;
}
