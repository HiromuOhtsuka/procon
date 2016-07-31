#include <cstdio>
#include <algorithm>
#define MAX_N 100000
#define MAX_M 100000
using namespace std;

static int N, M, X, Y, a[MAX_N], b[MAX_M];

int main(){
  scanf("%d %d %d %d", &N, &M, &X, &Y);
  for(int i = 0; i < N; i++){
    scanf("%d", &a[i]);
  }
  for(int i = 0; i < M; i++){
    scanf("%d", &b[i]);
  }

  sort(a, a + N);
  sort(b, b + M);
  unsigned long long time = 0;
  int count = 0;
  bool at_a = true, flag = false;
  while(true){
    if(at_a){
      int *t_a = lower_bound(a, a + N, time);
      if(t_a == a + N){
        flag = true;
        break;
      }
      time = *t_a + X;
      at_a = false;
    }
    else{
      int *t_b = lower_bound(b, b + M, time);
      if(t_b == b + M){
        flag = true;
        break;
      }
      time = *t_b + Y;
      at_a = true;
      ++count;
    }
    if(flag){
      break;
    }
  }

  printf("%d\n", count);

  return 0;
}
