#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

bool validate(int a[], int n){
  for(int i = 0; i + 1 < n; i++){
    if(a[i] > a[i + 1]){
      return false;
    }
  }
  return true;
}

void check(int a[], int n, int x[], int y[], int m){
  int b[n];
  for(int i = 0; i < n; i++){
    b[i] = a[i];
  }
  for(int i = 0; i < m; i++){
    b[y[i]] += b[x[i]];
  }
  if(validate(b, n)){
    cerr << "valid" << endl;
  }
  else{
    cerr << "invalid" << endl;
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n];
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }

  int ma = 0;
  int mi = 0;
  for(int i = 1; i < n; i++){
    if(a[ma] < a[i]){
      ma = i;
    }
    if(a[mi] > a[i]){
      mi = i;
    }
  }

  int y[2 * n - 1], x[2 * n - 1];
  int sp = 0;
  if(abs(a[ma]) >= abs(a[mi])){
    for(int i = 0; i < n; i++){
      y[sp] = i;
      x[sp] = ma;
      ++sp;
    }
    for(int j = 0; j < n - 1; j++){
      y[sp] = j + 1;
      x[sp] = j;
      ++sp;
    }
  }
  else{
    for(int i = 0; i < n; i++){
      y[sp] = i;
      x[sp] = mi;
      ++sp;
    }
    for(int j = n - 1; j > 0; j--){
      y[sp] = j - 1;
      x[sp] = j;
      ++sp;
    }
  }

  string s;
  s += to_string(2 * n - 1) + "\n";
  for(int i = 0; i < 2 * n - 1; i++){
    s += to_string(x[i] + 1) + " ";
    s += to_string(y[i] + 1) + "\n";
  }

  if(DEBUG){
    check(a, n, x, y, 2 * n - 1);
  }

  cout << s << endl;

  return 0;
}
