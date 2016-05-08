#include <cstdio>
#define MAX_D 10000
#define MAX_K 100

static int N, D, K;
static int S[MAX_K], T[MAX_K];

typedef struct {
  int n;
  int l, r;
} vertex_t;

static vertex_t V[MAX_D];

int main(){
  scanf("%d %d %d", &N, &D, &K);
  for(int i = 0; i < D; i++){
    V[i].n = i + 1;
    scanf("%d %d", &V[i].l, &V[i].r);
  }

  for(int i = 0; i < K; i++){
    scanf("%d %d", &S[i], &T[i]);
  }

  for(int i = 0; i < K; i++){
    int d = 0;
    int st = S[i];
    for(int j = 0; j < D; j++){
      if(st == T[i]){
        d = j + 1;
        break;
      }
      else if(V[j].l <= st && st <= V[j].r){
        if(V[j].r < T[i]){
          st = V[j].r;
        }
        else if(V[j].l > T[i]){
          st = V[j].l;
        }
        else if(V[j].l <= T[i] && T[i] <= V[j].r){
          d = j + 1;
          break;
        }
      }
    }
    printf("%d\n", d);
  }

  return 0;
}

