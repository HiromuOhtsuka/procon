#include <cstdio>
#define MAX_N 100000
using namespace std;

static int N, S, A[MAX_N];

int main(){
  int C;

  scanf("%d", &C);
  for(int i = 0; i < C; i++){
    scanf("%d %d", &N, &S);
    for(int j = 0; j < N; j++){
      scanf("%d", &A[j]);
    }

    int sum = 0, s = 0, t = 0, ans = N + 1;
    while(true){
      while(t < N && sum < S){
        sum += A[t++];
      }
      if(sum >= S){
        ans = (t - s) < ans ? (t - s) : ans;
        sum -= A[s++];
      }
      else{
        break;
      }
    }
    if(ans > N){
      ans = 0;
    }

    printf("%d\n", ans);
  }

  return 0;
}
