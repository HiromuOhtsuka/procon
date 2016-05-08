#include <cstdio>
#define MAX_N 20
using namespace std;

static int N;

int main(){
  scanf("%d", &N);

  int ans = MAX_N + 1, max_v = -1;
  for(int i = 0; i < N; i++){
    int a, v;
    scanf("%d %d", &a, &v);
    if(v > max_v){
      max_v = v;
      ans = a;
    }
    else if(v == max_v){
      if(a < ans){
        ans = a;
      }
    }
  }

  printf("%d %d\n", ans, max_v);

  return 0;
}
