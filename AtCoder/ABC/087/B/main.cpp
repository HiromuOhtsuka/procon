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

  int a, b, c, x;
  cin >> a >> b >> c >> x;

  int count = 0;
  for(int i = 0; i <= a; i ++){
    for(int j = 0; j <= b; j++){
      for(int k = 0; k <= c; k++){
        if(500 * i + 100 * j + 50 * k == x) ++count;
      }
    }
  }

  cout << count << endl;

  return 0;
}
