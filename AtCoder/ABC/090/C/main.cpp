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

  ll n, m;
  cin >> n >> m;

  if(n == 1 && m == 1){
    cout << 1 << endl;
  }
  else if(n == 1){
    cout << (m - 2) << endl;
  }
  else if(m == 1){
    cout << (n - 2) << endl;
  }
  else{
    cout << ((n - 2) * (m - 2)) << endl;
  }

  return 0;
}
