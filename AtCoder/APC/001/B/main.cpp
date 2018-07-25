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

  int n;
  cin >> n;
  ll a[n], b[n];
  for(int i = 0; i < n; i++) cin >> a[i];
  for(int i = 0; i < n; i++) cin >> b[i];

  ll count = 0;
  for(int i = 0; i < n; i++){
    if(a[i] < b[i]){
      count += (b[i] - a[i]) / 2;
    }
    else{
      count -= a[i] - b[i];
    }
  }

  if(count >= 0) cout << "Yes" << endl;
  else cout << "No" << endl;

  return 0;
}
