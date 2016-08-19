#include <iostream>
#include <algorithm>
#define MAX_N 200000
#define MAX_M 200000
using namespace std;

int N, M, a[MAX_N], b[MAX_M];

int main(){
  cin >> N >> M;
  for(int i = 0; i < N; i++){
    cin >> a[i];
  }
  for(int j = 0; j < M; j++){
    cin >> b[j];
  }
  sort(a, a + N);
  for(int j = 0; j < M; j++){
    int *p = upper_bound(a, a + N, b[j]);
    cout << (p - a) << ((j == M - 1) ? '\n' : ' ');
  }

  return 0;
}
