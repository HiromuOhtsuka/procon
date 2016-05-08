#include <iostream>
#include <cmath>
#define MAX_N 100000
#define MAX_M 100000
using namespace std;

int N, M, yado[MAX_N], a[MAX_M];

int main(){
  cin >> N >> M;
  for(int i = 1; i < N; i++){
    int d;
    cin >> d;
    yado[i] = yado[i - 1] + d;
  }

  for(int i = 0; i < M; i++){
    cin >> a[i];
  }

  int sum = 0, k = 0, x = 0;
  for(int i = 0; i < M; i++){
    k = k + a[i];
    sum = (sum + abs(x - yado[k]));
    sum = sum % 100000;
    x = yado[k];
  }

  cout << sum << endl;

  return 0;
}
