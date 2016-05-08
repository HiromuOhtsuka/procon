#include <cstdio>
#define MAX_N 1000
#define MAX_M 1000
using namespace std;

int N, M, a[MAX_N], num[MAX_M];

int main(){
  for(;;){
    scanf("%d %d", &N, &M);

    if(N == 0 && M == 0){
      return 0;
    }

    for(int i = 0; i < N; i++){
      scanf("%d", &a[i]);
    }

    for(int i = 0; i < M; i++){
      scanf("%d", &num[i]);
    }

    int here = 0;
    for(int i = 0; i < M; i++){
      here += num[i];
      if(here + 1 >= N){
        printf("%d\n", i + 1);
        break;
      }
      here += a[here];
      if(here + 1 >= N){
        printf("%d\n", i + 1);
        break;
      }
    }
  }

  return 0;
}
