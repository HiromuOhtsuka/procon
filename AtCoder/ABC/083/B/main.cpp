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

  int n, a, b;
  cin >> n >> a >> b;

  int sum = 0;
  for(int i = 1; i <= n; i++){
    int s = 0;
    int j = i;
    while(j != 0){
      s += j % 10;
      j /= 10;
    }
    if(s >= a && s <= b){
      sum += i;
    }
  }

  cout << sum << endl;

  return 0;
}
