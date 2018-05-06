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

  int c[3][3];
  for(int i = 0; i < 3; i++){
    for(int j = 0; j < 3; j++){
      cin >> c[i][j];
    }
  }

  bool exist = false;
  for(int a1 = -100; a1 <= 100; a1++){
    int b1 = c[0][0] - a1;
    int b2 = c[0][1] - a1;
    int b3 = c[0][2] - a1;
    int a2 = c[1][0] - b1;
    int a3 = c[2][0] - b1;
    if(c[1][1] == a2 + b2 && 
      c[2][1] == a3 + b2 &&
      c[1][2] == a2 + b3 &&
      c[2][2] == a3 + b3){
      exist = true;
      break;
    }
  }

  if(exist) cout << "Yes" << endl;
  else cout << "No" << endl;

  return 0;
}
