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

static bool done[MAX_D];
static void init_done();
static int search(int m, int st);

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
    for(int j = 0; j < D; j++){
      if(V[j].l <= T[i] && T[i] <= V[j].r){
        init_done();
        int d = search(S[i], j);
        if(d != 0){
          printf("%d\n", V[j].n);
          break;
        }
      }
    }
  }

  return 0;
}

int search(int m, int st){
  if(done[st]){
    return 0;
  }

  done[st] = true;

  if(V[st].l <= m && m <= V[st].r){
    return V[st].n;
  }

  for(int i = 0; i < D; i++){
    if(i == st){
      continue;
    }
    if(!(V[st].r < V[i].l || V[i].r < V[st].l) && V[i].n < V[st].n){
      int d = search(m, i);
      if(d != 0){
        return d;
      }
      done[i] = false;
    }
  }

  return 0;
}

static void init_done(){
  for(int i = 0; i < D; i++){
    done[i] = false;
  }
}

