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

  while(true){
    int b;
    cin >> b;
    if(b == 0) break;

    int d = 1;
    while(d * (d - 1) / 2 < b){
      ++d;
    }

    int x = b;
    for(; d >= 1; d--){
      if(d * (d - 1) / 2 > b) continue;
      if((b - d * (d - 1) / 2) % d == 0){
        x = (b - d * (d - 1) / 2) / d;
        if(x >= 1) break;
      }
    }

    cout << x << " " << d << endl;
  }

  return 0;
}
