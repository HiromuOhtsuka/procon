nclude <cstdio>
#include <vector>
#define MAX_N 4000
using namespace std;

static int N;
static unsigned long long sum[MAX_N + 1];
static vector< int > order;

int main(){
  while(true){
    scanf("%d", &N);

    if(N == 0){
      return 0;
    }

    for(int i = 0; i < N; i++){
      int n;
      unsigned long long p, m;
      scanf("%d %llu %llu", &n, &p, &m);
      if(sum[n] == 0){
        order.push_back(n);
      }
      sum[n] += p * m;
    }

    bool na = true;
    for(int i = 0; i < order.size(); i++){
      if(sum[order[i]] >= 1000000){
        printf("%d\n", order[i]);
        na = false;
      }
    }
    if(na){
      printf("NA\n");
    }

    for(int i = 0; i <= MAX_N; i++){
      sum[i] = 0;
    }
    order.clear();
  }

  return 0;
}
