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

  int n, z, w;
  cin >> n >> z >> w;
  int a[n];
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }

  if(n == 1){
    cout << abs(a[n - 1] - w) << endl;
  }
  else{
    cout << max(abs(a[n - 1] - w), abs(a[n - 1] - a[n - 2])) << endl;
  }

  return 0;
}
