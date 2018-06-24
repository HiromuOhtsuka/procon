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

//int mid(int x, int y, int z){
//  int a[3];
//  a[0] = x; a[1] = y; a[2] = z;
//  sort(a, a + 3);
//  return a[1];
//}
//
//bool check(int n, int x, int a[]){
//  int result[n][2 * n - 1];
//  for(int i = 0; i < 2 * n - 1; i++){
//    result[n - 1][i] = a[i];
//  }
//  for(int i = n - 2; i >= 0; i--){
//    for(int j = 0; j < 2 * (i + 1) - 1; j++){
//      result[i][j] = mid(
//        result[i + 1][j],
//        result[i + 1][j + 1],
//        result[i + 1][j + 2]);
//    }
//  }
//  return x == result[0][0];
//}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, x;
  cin >> n >> x;

  if(x == 1 || x == (2 * n - 1)){
    cout << "No" << endl;
    return 0;
  }

  if(n == 2){
    if(x != 2){
      cout << "No" << endl;
    }
    else{
      cout << "Yes" << endl;
      cout << "1\n2\n3" << endl;
    }
    return 0;
  }

  int a[2 * n - 1];
  queue< int > r;
  if(x != 2){
    a[n - 2] = x - 1;
    a[n - 1] = x;
    a[n] = x + 1;
    a[n + 1] = x - 2;
    for(int i = 0; i < 2 * n - 1; i++){
      if(i + 1 == x - 1 ||
          i + 1 == x ||
          i + 1 == x + 1 ||
          i + 1 == x - 2) continue;
      r.push(i + 1);
    }
  }
  else{
    a[n - 2] = x + 1;
    a[n - 1] = x;
    a[n] = x - 1;
    a[n + 1] = x + 2;
    for(int i = 0; i < 2 * n - 1; i++){
      if(i + 1 == x + 1 ||
          i + 1 == x ||
          i + 1 == x - 1 ||
          i + 1 == x + 2) continue;
      r.push(i + 1);
    }
  }

  for(int i = 0; i < n - 2; i++){
    a[i] = r.front(); r.pop();
  }
  for(int i = n + 2; i < 2 * n - 1; i++){
    a[i] = r.front(); r.pop();
  }

  string buf;
  for(int i = 0; i < 2 * n - 1; i++){
    buf += to_string(a[i]) + "\n";
  }

  cout << "Yes" << endl;
  cout << buf;

  //cout << check(n, x, a);

  return 0;
}
