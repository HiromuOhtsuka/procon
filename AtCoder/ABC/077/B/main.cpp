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

  ll n;
  cin >> n;

  ll low = 0, high = 100000;
  while(high - low > 1){
    ll mid = (low + high) / 2;
    if(mid * mid <= n){
      low = mid;
    }
    else{
      high = mid;
    }
  }

  cout << (low * low) << endl;

  return 0;
}
