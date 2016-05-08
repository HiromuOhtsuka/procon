#include <cstdio>
#define MAX_N 200
using namespace std;

static int N, M;
static int card[MAX_N], w[MAX_N];
static void cut(int k){
  for(int i = 0; i < k; i++){
    w[N - k + i] = card[i];
  }
  for(int i = k; i < N; i++){
    w[i - k] = card[i];
  }
  for(int i = 0; i < N; i++){
    card[i] = w[i];
  }
}

static void shuffle(){
  for(int i = 0; i < N / 2; i++){
    w[2 * i] = card[i];
  }
  for(int i = N / 2; i < N; i++){
    w[2 * (i - N / 2) + 1] = card[i];
  }
  for(int i = 0; i < N; i++){
    card[i] = w[i];
  }
}

int main(){
  scanf("%d", &N);
  N *= 2;
  for(int i = 0; i < N; i++){
    card[i] = i + 1;
  }
  scanf("%d", &M);
  for(int i = 0; i < M; i++){
    int k;
    scanf("%d", &k);
    if(k > 0){
      cut(k);
    }
    else{
      shuffle();
    }
  }
  for(int i = 0; i < N; i++){
    printf("%d\n", card[i]);
  }

  return 0;
}
