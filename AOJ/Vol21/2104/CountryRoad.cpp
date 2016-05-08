#include <cstdio>
#include <algorithm>
#define MAX_N 100000
#define MAX_K 100000
using namespace std;;

int T;
int N, K, x[MAX_N];
int y[MAX_N];

int main(){
  scanf("%d", &T);
  for(int c = 0; c < T; c++){
    scanf("%d %d", &N, &K);
    for(int i = 0; i < N; i++){
      scanf("%d", &x[i]);
    }

    int sp = 0;
    for(int i = 0; i < N - 1; i++){
      y[sp++] = x[i + 1] - x[i];
    }
    sort(y, y + sp);
    int len = x[N - 1] - x[0];
    for(int i = 0; i < K - 1; i++){
      if(len - y[(sp - 1) - i] >= 0){
        len -= y[(sp - 1) - i];
      }
    }

    printf("%d\n", len);
  }

  return 0;
}
