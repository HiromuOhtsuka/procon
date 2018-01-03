#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

typedef long long ll;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  ll x, y;
  cin >> x >> y;

  ll z = x;
  int count = 0;
  while(z <= y){
    z <<= 1;
    ++count;
  }

  cout << count << endl;

  return 0;
}
