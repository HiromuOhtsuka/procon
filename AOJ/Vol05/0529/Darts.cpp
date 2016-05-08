#include <cstdio>
#include <algorithm>
#define MAX_N 1001
using namespace std;

static int N, M, P[MAX_N];
static int ab[MAX_N * MAX_N];

int main(){
  for(;;){
    scanf("%d %d", &N, &M);

    if(N == 0 && M == 0){
      return 0;
    }

    for(int i = 0; i < N; i++){
      scanf("%d", &P[i]);
    }

    for(int i = 0; i < N + 1; i++){
      for(int j = 0; j < N + 1; j++){
        ab[i * (N + 1) + j] = P[i] + P[j];
      }
    }

    sort(ab, ab + (N + 1) * (N + 1));
    int S = -1;
    for(int i = 0; i < (N + 1) * (N + 1); i++){
      int cd = ab[i];
      int *_ab = upper_bound(ab, ab + (N + 1) * (N + 1), M - cd) - 1;
      if(S < *_ab + cd && *_ab + cd <= M){
        S = *_ab + cd;
      }
    }

    printf("%d\n", S);

    for(int i = 0; i < MAX_N; i++){
      P[i] = 0;
    }
  }

  return 0;
}
