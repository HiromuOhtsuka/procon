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

  char x, y;
  cin >> x >> y;
  if(x == y){
    cout << "=" << endl;
  }
  else if(x < y){
    cout << "<" << endl;
  }
  else{
    cout << ">" << endl;
  }

  return 0;
}
