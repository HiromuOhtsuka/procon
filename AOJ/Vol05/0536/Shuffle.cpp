#include <cstdio>
using namespace std;

static int N, M;
static int card[6];
static void init_card(){
  for(int i = 2; i < 6; i++){
    card[i] = 0;
  }
  card[0] = 1;
  card[1] = N;
}

static void suffle(int x, int y){
}

int main(){
  while(true){
    scanf("%d %d", &N, &M);
    init_card();
    int p, q, r;
    scanf("%d %d %d", &p, &q, &r);
    for(int i = 0; i < M; i++){
      int x, y;
      scanf("%d %d", &x, &y);
      suffle(x, y);
    }
  }

  return 0;
}
