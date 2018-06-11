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

  int x;
  cin >> x;

  int ans = 1;
  for(int b = 2; b * b <= x; b++){
    int c = 1;
    while(c * b <= x){
      c *= b;
    }
    ans = max(ans, c);
  }

  cout << ans << endl;

  return 0;
}
