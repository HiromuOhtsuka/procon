#include <cstdio>
using namespace std;

static int S, N;
static int m;
static void sum_of_integers(int i, int k, int u){
  if(k == 0 && u == S){
    ++m;
    return;
  }
  if(i == 10 || k == 0){
    return;
  }
  sum_of_integers(i + 1, k - 1, u + i);
  sum_of_integers(i + 1, k, u);
}

int main(){
  scanf("%d %d", &N, &S);
  while(S != 0 || N != 0){
    m = 0;
    sum_of_integers(0, N, 0);
    printf("%d\n", m);
    scanf("%d %d", &N, &S);
  }
}
