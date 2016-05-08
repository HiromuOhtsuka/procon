#include <iostream>
#include <cstdio>
#include <algorithm>
#define MAX_N 100
#define MAX_K MAX_N
using namespace std;

int N, K;
double r[MAX_N];

int main(){
  cin >> N >> K;
  for(int i = 0; i < N; i++){
    cin >> r[i];
  }

  sort(r, r + N);
  double c = 0.0;
  for(int i = 0; i < K; i++){
    c = (c + r[N - K + i]) / 2.0;
  }

  printf("%.6lf\n", c);

  return 0;
}
