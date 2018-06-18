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

  int a, b;
  cin >> a >> b;

  int x = 1;
  for(int i = 1; i + 1 <= 999; i++){
    int left = i * (i + 1) / 2;
    int right = (i + 1) * (i + 2) / 2;
    if(abs(left - right) == abs(a - b) && left - a >= 0){
      x = left - a;
      break;
    }
  }

  cout << x << endl;

  return 0;
}
