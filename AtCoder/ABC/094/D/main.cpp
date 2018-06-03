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
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  sort(a, a + n);

  int target = a[n - 1] / 2;
  int* lb = lower_bound(a, a + n - 1, target);

  int ans;
  if(lb != a){
    if(lb == a + n - 1) ans = *(lb - 1);
    else if(abs(*lb - target) <= abs(*(lb - 1) - target))
      ans = *lb;
    else ans = *(lb - 1);
  }
  else{
    ans = *lb;
  }

  cout << a[n - 1] << " " << ans << endl;

  return 0;
}
