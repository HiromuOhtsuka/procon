#include <cstdio>
#include <algorithm>
#define MAX_N 4000
using namespace std;

static int N;
static int A[MAX_N], B[MAX_N], C[MAX_N], D[MAX_N];
static int W[MAX_N * MAX_N];

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    scanf("%d", &A[i]);
    scanf("%d", &B[i]);
    scanf("%d", &C[i]);
    scanf("%d", &D[i]);
  }

  int sp = 0;
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      W[sp++] = C[i] + D[j];
    }
  }
  sort(W, W + N * N);
  long long count = 0;
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      int tar = -(A[i] + B[j]);
      count += upper_bound(W, W + N * N, tar) - lower_bound(W, W + N * N, tar);
    }
  }

  printf("%lld\n", count);

  return 0;
}
