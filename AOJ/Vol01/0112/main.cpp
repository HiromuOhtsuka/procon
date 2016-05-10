#include <cstdio>
#include <algorithm>
#define MAX_N 10000
using namespace std;

static int N, time[MAX_N];

int main(){
  while(true){
    scanf("%d", &N);

    if(N == 0){
      return 0;
    }

    for(int i = 0; i < N; i++){
      scanf("%d", &time[i]);
    }

    sort(time, time + N);
    long long tmp = 0, sum = 0;
    for(int i = 1; i < N; i++){
      tmp += time[i - 1];
      sum += tmp;
    }

    printf("%llu\n", sum);
  }

  return 0;
}
