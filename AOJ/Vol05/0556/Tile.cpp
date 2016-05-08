#include <cstdio>
#include <cmath>
#include <algorithm>
using namespace std;

static int N, K;

int main(){
  scanf("%d %d", &N, &K);
  for(int i = 0; i < K; i++){
    int a, b;
    scanf("%d %d", &a, &b);
    --a; --b;
    int d, m;
    if(N % 2 == 1){
      d = max(abs(a - N / 2), abs(b - N / 2));
      m = abs(d - N / 2) % 3;
    }
    else{
      d = max(min(abs(a - N / 2), abs(a - (N / 2 - 1))), 
          min(abs(b - N / 2), abs(b - (N / 2 - 1))));
      m = abs(d - (N / 2 - 1)) % 3;
    }
    printf("%d\n", m + 1);
  }

  return 0;
}
