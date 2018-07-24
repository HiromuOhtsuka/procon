#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#include <deque>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

typedef long long ll;
typedef pair< int, int > pii;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int a[3];
  cin >> a[0] >> a[1] >> a[2];

  int ans = INF_INT;
  int p[3] = {0, 1, 2};
  do{
    ans = min(ans,
        abs(a[p[0]] - a[p[1]]) + abs(a[p[1]] - a[p[2]]));
  }while(next_permutation(p, p + 3));

  cout << ans << endl;

  return 0;
}
