#include <cstdio>
using namespace std;

static int N;

int main(){
  scanf("%d", &N);
  int sum = 0;
  for(int i = 0; i < N; i++){
    int n;
    scanf("%d", &n);
    sum = sum + n + sum;
  }
  printf("%d\n", sum);
  return 0;
}
