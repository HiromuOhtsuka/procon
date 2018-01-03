#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int a, b, c, d;
  cin >> a >> b >> c >> d;

  if((a + b) > (c + d)){
    cout << "Left" << endl;
  }
  else if((a + b) < (c + d)){
    cout << "Right" << endl;
  }
  else{
    cout << "Balanced" << endl;
  }

  return 0;
}
