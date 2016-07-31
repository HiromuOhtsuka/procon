#include <cstdio>
using namespace std;

static int A, B, C, D;

int main(){
  scanf("%d %d %d %d", &A, &B, &C, &D);

  if(C * B > A * D){
    printf("TAKAHASHI\n");
  }
  else if(C * B < A * D){
    printf("AOKI\n");
  }
  else{
    printf("DRAW\n");
  }

  return 0;
}

