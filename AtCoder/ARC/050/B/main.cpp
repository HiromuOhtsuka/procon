#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
#define LL_INF (LONG_LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

typedef long long ll;

ll r, b, x, y;

bool f(ll k){
  return (r - k) / (x - 1) + (b - k) / (y - 1) >= k;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> r >> b;
  cin >> x >> y;

  ll low = 0, high = min(r, b) + 1;
  while(high - low > 1){
    ll mid = (low + high) / 2;
    if(f(mid)){
      low = mid;
    }
    else{
      high = mid;
    }
  }

  cout << low << endl;

  return 0;
}
