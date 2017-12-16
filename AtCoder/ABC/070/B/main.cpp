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
  if(b <= c || d <= a){
    cout << "0" << endl;
  }
  else{
    cout << (min(b, d) - max(a, c)) << endl;
  }

  return 0;
}
