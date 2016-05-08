#include <iostream>
#include <algorithm>
#include <cmath>
#define MAX_N 100000000
#define MAX_A 10000
using namespace std;

int N, a[MAX_A];
int y[MAX_A * 4];

int keta(int n){
  int count = 1;
  while(n / 10){
    n /= 10;
    count++;
  }
  return count;
}

int main(){
  cin >> N;
  for(int i = 0; i < N; i++){
    cin >> a[i];
  }

  sort(a, a + N);
  N = min(N, MAX_A);
  int sp = 0;
  for(int i = 0; i < 4; i++){
    for(int j = 0; j < N; j++){
      if(i == j){
        continue;
      }
      int n = keta(a[j]);
      y[sp++] = (a[i] * powl(10, n) + a[j]);
    }
  }
  sort(y, y + sp);

  cout << y[2] << endl;

  return 0;
}
