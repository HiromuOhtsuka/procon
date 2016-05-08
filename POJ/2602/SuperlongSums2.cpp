#include <cstdio>
#define MAX_N 1000000
using namespace std;

static int N, A[MAX_N], B[MAX_N], C[MAX_N];
int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    scanf("%d %d", &A[i], &B[i]);
  }
  int c = 0, sp = 0;
  for(int i = N - 1; i >= 0; i--){
    int tmp = c;
    c = (A[i] + B[i] + c) / 10;
    C[sp++] = (A[i] + B[i] + tmp) % 10;
  }

  for(int i = N - 1; i >= 0; i--){
    printf("%d", C[i]);
  }
  putchar('\n');


  return 0;
}
