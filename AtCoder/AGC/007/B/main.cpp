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

bool check(int a[], int b[], int p[], int n){
  for(int i = 0; i < n; i++){
    if(a[i] <= 0) return false;
  }
  for(int i = 0; i < n; i++){
    if(b[i] <= 0) return false;
  }
  for(int i = 0; i + 1 < n; i++){
    if(a[i] >= a[i + 1]) return false;
  }
  for(int i = n - 1; i - 1 >= 0; i--){
    if(b[i - 1] <= b[i]) return false;
  }
  for(int i = 0; i + 1 < n; i++){
    if(a[p[i]] + b[p[i]] >= a[p[i + 1]] + b[p[i + 1]])
      return false;
  }
  return true;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int p[n];
  for(int i = 0; i < n; i++){
    cin >> p[i];
    --p[i];
  }

  int r[n];
  for(int i = 0; i < n; i++) r[p[i]] = i + 1;

  int m = 40000;
  int a[n], b[n];
  for(int i = 0; i < n; i++){
    a[i] = m * (i + 1);
    b[i] = m * (n - (i + 1)) + r[i];
  }

  string buf;
  for(int i = 0; i < n; i++){
    buf += to_string(a[i]);
    if(i != n - 1) buf += " ";
  }
  buf += "\n";
  for(int i = 0; i < n; i++){
    buf += to_string(b[i]);
    if(i != n - 1) buf += " ";
  }

  cout << buf << endl;

  //cout << check(a, b, p, n) << endl;

  return 0;
}
