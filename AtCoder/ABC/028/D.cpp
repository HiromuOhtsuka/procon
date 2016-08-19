#include <cstdio>
using namespace std;

static int N, K;

int main(){
  scanf("%d %d", &N, &K);

  unsigned long long a = 6 * (K - 1) * (N - K) + 3 *(N - 1) + 1;
  unsigned long long b = N * N * N;
  int ans[22];
  ans[0] = 0;
  for(int i = 1; i < 22; i++){
    ans[i] = (int)(10.0 * ((double)a / (double)b)) % 10;
    a = b * (ans[i - 1] - (unsigned long long)(10.0 * ((double)a / (double)b)));
  }

  printf("%d.", ans[0]);
  for(int i = 1; i < 20; i++){
    printf("%d", ans[i]);
  }
  printf("%d\n", ans[20] + (ans[21] >= 5));

  return 0;
}
