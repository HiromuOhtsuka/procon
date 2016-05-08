#include <cstdio>
#define MAX_N 100000
using namespace std;

static int N, K;
static int data[MAX_N];

int main(){
  while(true){
    scanf("%d %d", &N, &K);
    if(N == 0 && K == 0){
      return 0;
    }
    int sum = 0, max = -10000001, count = 0;
    for(int i = 0; i < N; i++){
      scanf("%d", &data[i]);
      sum += data[i];
      ++count;
      if(count >= K){
        --count;
        if(sum > max){
          max = sum;
        }
        sum -= data[i - K + 1];
      }
    }
    printf("%d\n", max);
  }

  return 0;
}
