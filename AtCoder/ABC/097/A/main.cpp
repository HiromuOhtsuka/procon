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

  int a, b, c, d;
  cin >> a >> b >> c >> d;

  if(abs(a - c) <= d || (abs(a - b) <= d && abs(b - c) <= d))
    cout << "Yes" << endl;
  else cout << "No" << endl;

  return 0;
}
