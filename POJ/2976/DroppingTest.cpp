#include <cstdio>
#include <algorithm>
#include <cmath>
#define MAX_N 1010
using namespace std;

static int N, K, A[MAX_N], B[MAX_N];
static int best;
static bool able(double ave);
static void search();

int main(){
  while(true){
    scanf("%d %d", &N, &K);
    if(N == 0 && K == 0){
      return 0;
    }
    for(int i = 0; i < N; i++){
      scanf("%d", &A[i]);
    }
    for(int i = 0; i < N; i++){
      scanf("%d", &B[i]);
    }
    search();
    printf("%d\n", best);
  }

  return 0;
}

static bool able(double ave){
  double val[N];
  for(int i = 0; i < N; i++){
    val[i] = 100.0 * (double)A[i] - ave * B[i];
  }
  sort(val, val + N);
  double sum = 0;
  for(int i = K; i < N; i++){
    sum += val[i];
  }
  return sum >= 0;
}

static void search(){
  double low = 0, high = 100;

  for(int i = 0; i < 100; i++){
    double mid = (low + high) / 2;
    if(able(mid)){
      low = mid;
    }
    else{
      high = mid;
    }
  }

  best = (int)(floor(low + 0.5));
}

