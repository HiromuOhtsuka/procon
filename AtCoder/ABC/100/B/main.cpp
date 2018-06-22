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

  int d, n;
  cin >> d >> n;

  int ans;
  switch(d){
    case 0: ans = (n != 100) ? n : 101; break;
    case 1: ans = (n != 100) ? n * 100 : 10100; break;
    case 2: ans = (n != 100) ? n * 100 * 100 : 1010000; break;
  }

  cout << ans << endl;

  return 0;
}
