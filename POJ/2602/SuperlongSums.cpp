#include <cstdio>
#define MAX_N 1000000
using namespace std;

static int N;

int main(){
  scanf("%d", &N);
  int a, b;
  scanf("%d %d", &a, &b);
  int tmp = (a + b) % 10;
  for(int i = 0; i < N - 1; i++){
    scanf("%d %d", &a, &b);
    printf("%d", (tmp + (a + b) / 10) % 10);
    tmp = (a + b) % 10;
  }
  printf("%d\n", (tmp % 10));

  return 0;
}
