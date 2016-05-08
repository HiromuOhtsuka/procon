#include <cstdio>
#include <algorithm>
#define MAX_N 100000
#define MAX_M 10000
using namespace std;

static int N, M, D, dist[MAX_N];
static int cal_dist(int k){
  int *p = lower_bound(dist, dist + N, k);
  return min(k - *(p - 1), *p - k);
}


int main(){
  while(true){
    scanf("%d %d %d", &D, &N, &M);
    if(D == 0){
      return 0;
    }
    for(int i = 0; i < N - 1; i++){
      scanf("%d", &dist[i]);
    }
    dist[N - 1] = D;
    sort(dist, dist + N);
    int sum = 0;
    for(int i = 0; i < M; i++){
      int k;
      scanf("%d", &k);
      sum += cal_dist(k);
    }
    printf("%d\n", sum);
  }
  return 0;
}
