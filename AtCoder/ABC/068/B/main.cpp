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

  if(n >= 64){
    cout << 64 << endl;
  }
  else if(n >= 32){
    cout << 32 << endl;
  }
  else if(n >= 16){
    cout << 16 << endl;
  }
  else if(n >= 8){
    cout << 8 << endl;
  }
  else if(n >= 4){
    cout << 4 << endl;
  }
  else if(n >= 2){
    cout << 2 << endl;
  }
  else{
    cout << 1 << endl;
  }

  return 0;
}
