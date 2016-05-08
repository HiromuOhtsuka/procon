#include <cstdio>
#define MAX_N 1000
#define MAX_M 300
using namespace std;

static int A, B, C, N;
static const int BROKEN = 0, UNBROKEN = 1, UNKNOWN = 2;
static int table[MAX_M + 1];
struct Test {
  int i, j, k, r;

  Test(){}
  Test(int ii, int jj, int kk, int rr){
    i = ii; j = jj; k = kk; r = rr;
  }
};

static Test tests[MAX_N];

int main(){
  while(true){
    scanf("%d %d %d", &A, &B, &C);
    if(A == 0 && B == 0 && C == 0){
      return 0;
    }
    for(int i = 0; i <= A + B + C; i++){
      table[i] = UNKNOWN;
    }
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
      int a, b, c, d;
      scanf("%d %d %d %d", &a, &b, &c, &d);
      tests[i] = Test(a, b, c, d);
    }
    // UNBROKEN
    for(int i = 0; i < N; i++){
      if(tests[i].r){
        table[tests[i].i] = table[tests[i].j]
          = table[tests[i].k] = UNBROKEN;
      }
    }
    // BROKEN
    for(int i = 0; i < N; i++){
      if(!tests[i].r){
        if(table[tests[i].i] == UNBROKEN &&
           table[tests[i].j] == UNBROKEN){
          table[tests[i].k] = BROKEN;
        }
        else if(table[tests[i].i] == UNBROKEN &&
           table[tests[i].k] == UNBROKEN){
          table[tests[i].j] = BROKEN;
        }
        else if(table[tests[i].k] == UNBROKEN &&
           table[tests[i].j] == UNBROKEN){
          table[tests[i].i] = BROKEN;
        }
      }
    }
    for(int i = 1; i <= A + B + C; i++){
      printf("%d\n", table[i]);
    }
  }

  return 0;
}

